package com.minres.structural.ui.hyperlink;

import com.google.inject.Inject;
import com.minres.structural.ui.hyperlink.MyXtextHyperlink;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

@SuppressWarnings("all")
public class MyHyperlinkHelper extends HyperlinkHelper {
  @Inject
  private ImportUriResolver resolver;
  
  @Override
  public void createHyperlinksByOffset(final XtextResource resource, final int offset, final IHyperlinkAcceptor acceptor) {
    final TextRegion region = new TextRegion(offset, 0);
    final INode crossRefNode = this.getEObjectAtOffsetHelper().getCrossReferenceNode(resource, region);
    if ((crossRefNode == null)) {
      final IParseResult parseResult = resource.getParseResult();
      if ((parseResult != null)) {
        final ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), region.getOffset());
        final EObject semObj = NodeModelUtils.findActualSemanticObjectFor(leaf);
        final String importURI = this.resolver.resolve(semObj);
        if (((importURI != null) && EcoreUtil2.isValidUri(semObj, URI.createURI(importURI)))) {
          final Resource referencedResource = EcoreUtil2.getResource(resource, importURI);
          if (((referencedResource != null) && (referencedResource.getContents().size() > 0))) {
            final EObject top = referencedResource.getContents().get(0);
            final ITextRegion textRegion = leaf.getTextRegion();
            final URI uri = EcoreUtil.getURI(top);
            final XtextHyperlink result = this.getHyperlinkProvider().get();
            int _offset = textRegion.getOffset();
            int _length = textRegion.getLength();
            Region _region = new Region(_offset, _length);
            result.setHyperlinkRegion(_region);
            URI _xifexpression = null;
            boolean _isPlatformResource = uri.isPlatformResource();
            if (_isPlatformResource) {
              _xifexpression = uri;
            } else {
              _xifexpression = resource.getResourceSet().getURIConverter().normalize(uri);
            }
            result.setURI(_xifexpression);
            result.setHyperlinkText(this.getLabelProvider().getText(top));
            if ((result instanceof MyXtextHyperlink)) {
              ((MyXtextHyperlink)result).setSelectTarget(false);
            }
            acceptor.accept(result);
          }
        }
      }
    } else {
      final EObject crossLinkedEObject = this.getEObjectAtOffsetHelper().getCrossReferencedElement(crossRefNode);
      if (((crossLinkedEObject != null) && (!crossLinkedEObject.eIsProxy()))) {
        this.createHyperlinksTo(resource, crossRefNode, crossLinkedEObject, acceptor);
      }
    }
  }
}
