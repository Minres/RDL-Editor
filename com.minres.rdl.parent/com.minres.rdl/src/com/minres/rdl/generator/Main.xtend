package com.minres.rdl.generator

import com.google.inject.Inject
import com.google.inject.Provider
import com.minres.rdl.RDLStandaloneSetup
import java.lang.reflect.MalformedParametersException
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.mwe.utils.ProjectMapping
import org.eclipse.emf.mwe.utils.StandaloneSetup
import org.eclipse.xtext.generator.GeneratorDelegate
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import java.text.ParseException
import com.minres.rdl.generator.Options.Multiplicity
import com.minres.rdl.generator.Options.Separator
import org.eclipse.xtext.generator.IFileSystemAccess
import java.io.File

class Main {

    val USAGE_STR = '''
    RDL2code [-h] [-v] [-f] [-I <RDL include dir>] [-o <output dir>] [-sc [-n <namespace>] [-sc-dir <dir modifier>]] [-fw [-fw-dir <dir modifier>]] <input file> <input file>
        The following switches are supported:
        -h                              prints help page
        -v                              verbose output
        -f                              force overwrite existing files
        -I <RDL include dir>            include directory to search included RDL files
        -o <output dir>                 output directory of generated files
        -fw                             generate FW include files. The following sub 
                                        switches are supported:
            -fw-dir <dir modifier>      set the directory modifier (relative path to output dir
        -sc                             generate SystemC stubs. The following sub switches
                                        are supported
            -n <namespace>              the namespace to use for the generated SystemC component
            -sc-dir <dir modifier>      set the directory modifier (relative path to output dir
    '''

    def static main(String[] args) {
        if (args.empty) {
            System::err.println('Aborting: no path to RDL file provided!')
            return
        }
        val injector = new RDLStandaloneSetup().createInjectorAndDoEMFRegistration
        val main = injector.getInstance(Main)
        try {
            main.run(args)
        } catch (MalformedParametersException e) {
            print("Command line error " + e.message)
            System.exit(1)
        } catch (IllegalArgumentException e) {
            print("generation error " + e.message)
            e.printStackTrace
            System.exit(2)
        } catch (ParseException e) {
            print("parse problem " + e.message + " (" + e.errorOffset + ")")
            System.exit(3)
        }
    }

    @Inject Provider<ResourceSet> resourceSetProvider

    @Inject IResourceValidator validator

    @Inject GeneratorDelegate generator

    @Inject JavaIoFileSystemAccess fileAccess

    def run(String[] args) {
        val opt = new Options(args, 0, Integer.MAX_VALUE);
        val optionSet = opt.getSet()
        optionSet.addOption("h", Multiplicity.ZERO_OR_ONE);
        optionSet.addOption("v", Multiplicity.ZERO_OR_ONE);
        optionSet.addOption("f", Multiplicity.ZERO_OR_ONE);
        optionSet.addOption("n", Separator.BLANK, Multiplicity.ZERO_OR_ONE);
        optionSet.addOption("o", Separator.BLANK, Multiplicity.ZERO_OR_ONE);
        optionSet.addOption("I", Separator.BLANK, Multiplicity.ZERO_OR_ONE);
        optionSet.addOption("fw", Multiplicity.ZERO_OR_ONE);
        optionSet.addOption("sc", Multiplicity.ZERO_OR_ONE);
        optionSet.addOption("sc-dir", Separator.BLANK, Multiplicity.ZERO_OR_ONE);
        optionSet.addOption("fw-dir", Separator.BLANK, Multiplicity.ZERO_OR_ONE);
        if (!opt.check(false, false)) { // Print usage hints
            System.err.println("Usage is: " + USAGE_STR);
            throw new MalformedParametersException(opt.getCheckErrors());
        }
        // Normal processing
        if (optionSet.isSet("h")) {
            println("Usage: " + USAGE_STR);
            return
        }
        val verbose = if(optionSet.isSet("v")) true else false;
        val setup = new StandaloneSetup()
        if (optionSet.isSet("I")) {
            val projectMapping = new ProjectMapping
            projectMapping.projectName = "RDL Repository"
            projectMapping.path = new File(optionSet.getOption("I").getResultValue(0)).canonicalFile.absolutePath
            setup.addProjectMapping(projectMapping)
        }
        // Configure and start the generator
        fileAccess.outputPath = 'src-gen/'
        if(optionSet.isSet('o')){
            fileAccess.outputPath = optionSet.getOption('o').getResultValue(0)
            fileAccess.outputConfigurations.get(IFileSystemAccess.DEFAULT_OUTPUT)?.setOverrideExistingResources(true)
        }
        val context = new RdlGeneratorContext => [cancelIndicator = CancelIndicator.NullImpl]
        context.forceOverwrite= optionSet.isSet('f')
        if(optionSet.isSet('n'))
            context.namespace=optionSet.getOption('n').getResultValue(0)
        context.generateFw=optionSet.isSet('fw')
        context.generateSc=optionSet.isSet('sc')
        optionSet.getData().forEach [ String fileName |
            if(verbose) println("Processing " + fileName);
            // Load the resource
            val resourceSet = resourceSetProvider.get as XtextResourceSet
            resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
            val resource = resourceSet.getResource(URI.createFileURI(fileName), true)
            // Validate the resource
            val issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl)
            if (!issues.empty) {
                System.err.println("Error validating " + resource.URI)
                issues.forEach[System.err.println(it)]
                throw new ParseException("error validating " + resource.URI, issues.size)
            }
            generator.generate(resource, fileAccess, context)
            if(verbose) {
                println('Code generation for ' + fileName + ' finished')
                println('includes are in ' + fileAccess.getURI(''))
                println('sources are in  ' + fileAccess.getURI(''))
            }
        ]
    }
}
