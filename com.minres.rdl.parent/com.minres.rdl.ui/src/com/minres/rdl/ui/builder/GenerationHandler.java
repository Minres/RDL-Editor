package com.minres.rdl.ui.builder;


import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.IGenerator2;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.minres.rdl.generator.RdlGeneratorContext;
import com.minres.rdl.preferences.PreferenceConstants;

public class GenerationHandler extends AbstractHandler implements IHandler {

    @Inject
    private IGenerator2 generator;

    @Inject
    private Provider<EclipseResourceFileSystemAccess2> fileAccessProvider;

    @Inject
    IResourceDescriptions resourceDescriptions;

    @Inject
    IResourceSetProvider resourceSetProvider;

    IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(PreferenceConstants.SCOPE_NAME);

    @Override
    public Object execute(ExecutionEvent event) {
        RdlGeneratorContext context = new RdlGeneratorContext();
        context.cancelIndicator = CancelIndicator.NullImpl;
        context.namespace = preferences.get(PreferenceConstants.P_NAMESPACE, "sysc");
        context.forceOverwrite=preferences.getBoolean(PreferenceConstants.P_OVERWRITE_STUBS, false);
        String whatToGenerate = preferences.get(PreferenceConstants.P_FILETYPES_TO_GENERATE, "all");
        if(whatToGenerate=="sc-comp") {
            context.generateFw=false;
        } else if(whatToGenerate=="fw") {
            context.generateSc=false;
        }
        context.forceOverwrite=preferences.getBoolean(PreferenceConstants.P_OVERWRITE_STUBS, false);
        context.fwPathModifier=preferences.get(PreferenceConstants.P_FIRMWARE_PATH, "");
        context.scPathModifier=preferences.get(PreferenceConstants.P_COMPONENT_PATH, "");
        
        String outputDir = preferences.get("outlet.DEFAULT_OUTPUT.directory", "src-gen");
        IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
        IWorkbenchPart activePart = HandlerUtil.getActivePart(event);
        if (activeEditor instanceof XtextEditor && activeEditor == activePart) {
            IFile file = (IFile) activeEditor.getEditorInput().getAdapter(IFile.class);
            if (file != null) {
                final EclipseResourceFileSystemAccess2 fsa = getFsa(outputDir, file, context.fwPathModifier, context.scPathModifier);
                ((XtextEditor)activeEditor).getDocument().readOnly(new IUnitOfWork<Boolean, XtextResource>() {
                    @Override
                    public Boolean exec(XtextResource state) throws Exception {
                        generator.doGenerate(state, fsa, context);
                        return Boolean.TRUE;
                    }
                });
            }
        } else {
            ISelection selection = HandlerUtil.getCurrentSelection(event);
            if (selection instanceof IStructuredSelection) {
                IStructuredSelection structuredSelection = (IStructuredSelection) selection;
                for (Object element : structuredSelection) {
                    if (element instanceof IFile) {
                        IFile file = (IFile) element;
                        final EclipseResourceFileSystemAccess2 fsa = getFsa(outputDir, file, context.fwPathModifier, context.scPathModifier);
                        URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
                        Resource r = resourceSetProvider.get(file.getProject()).getResource(uri, true);
                        try {
                            generator.doGenerate(r, fsa, context);
                        } finally {}
                    }
                }
            }
        }
        return null;
    }

    private EclipseResourceFileSystemAccess2 getFsa(String outputDir, IFile file, String fwPath, String scPath) {
        IProject project = file.getProject();
        IFolder srcGenFolder = project.getFolder(outputDir);
        createIfNotExists(srcGenFolder);
        if(fwPath.length()>0) createIfNotExists(srcGenFolder.getFolder(fwPath));
        if(scPath.length()>0) createIfNotExists(srcGenFolder.getFolder(scPath));
        final EclipseResourceFileSystemAccess2 fsa = fileAccessProvider.get();
        fsa.setOutputPath("src-gen");
        String scGenFolderPath = (fwPath.length()>0? srcGenFolder.getFolder(scPath) : srcGenFolder).getProjectRelativePath().toString();
        fsa.setOutputPath("sc-incl-out", scGenFolderPath);
        fsa.setOutputPath("sc-src-out", scGenFolderPath);
        String fwGenFolderPath = (fwPath.length()>0? srcGenFolder.getFolder(fwPath) : srcGenFolder).getProjectRelativePath().toString();
        fsa.setOutputPath("fw-incl-out", fwGenFolderPath);
        fsa.setOutputPath("fw-src-out", fwGenFolderPath);
        fsa.setProject(project);
        fsa.setMonitor(new NullProgressMonitor());
        return fsa;
    }

	private void createIfNotExists(IFolder srcGenFolder) {
		if (!srcGenFolder.exists()) {
            try {
                srcGenFolder.create(true, true, new NullProgressMonitor());
            } catch (CoreException e) { }
        }
	}

    @Override
    public boolean isEnabled() {
        return true;
    }

}
