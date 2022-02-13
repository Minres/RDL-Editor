package com.minres.rdl.generator

import com.google.inject.Inject
import com.google.inject.Provider
import com.minres.rdl.RDLStandaloneSetup
import java.lang.reflect.MalformedParametersException
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.mwe.utils.ProjectMapping
import org.eclipse.emf.mwe.utils.StandaloneSetup
import org.eclipse.xtext.generator.GeneratorContext
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

class Main {

    val USAGE_STR = "RDL2code [-h] [-v] [-f] [-n <namespace>] [-I <RDL include dir] [-o <output dir>] <input file> <input file>";

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
        opt.getSet().addOption("h", Multiplicity.ZERO_OR_ONE);
        opt.getSet().addOption("v", Multiplicity.ZERO_OR_ONE);
        opt.getSet().addOption("f", Multiplicity.ZERO_OR_ONE);
        opt.getSet().addOption("n", Separator.BLANK, Multiplicity.ZERO_OR_ONE);
        opt.getSet().addOption("o", Separator.BLANK, Multiplicity.ZERO_OR_ONE);
        opt.getSet().addOption("I", Separator.BLANK, Multiplicity.ZERO_OR_ONE);
        if (!opt.check(false, false)) { // Print usage hints
            System.err.println("Usage is: " + USAGE_STR);
            throw new MalformedParametersException(opt.getCheckErrors());
        }
        // Normal processing
        if (opt.getSet().isSet("h")) {
            println("Usage: " + USAGE_STR);
            return
        }
        val verbose = if(opt.getSet().isSet("v")) true else false;

        if (opt.getSet().isSet("I")) {
            val projectMapping = new ProjectMapping
            projectMapping.projectName = "RDL Repository"
            projectMapping.path = opt.getSet().getOption("I").getResultValue(0)
            new StandaloneSetup().addProjectMapping(projectMapping)
        }
        // Configure and start the generator
        fileAccess.outputPath = 'src-gen/'
        if(opt.getSet().isSet('o')){
            fileAccess.outputPath = opt.getSet().getOption('o').getResultValue(0)
            fileAccess.outputConfigurations.get(IFileSystemAccess.DEFAULT_OUTPUT)?.setOverrideExistingResources(true)
        }
//        #{'incl-out' -> false, 'src-out' -> false, 'gen-out' -> true}.forEach[p1, p2|
//            if(opt.getSet().isSet(p1.substring(0, 1)))
//                fileAccess.setOutputPath(p1, opt.getSet().getOption(p1.substring(0, 1)).getResultValue(0)+'/')
//            else
//                fileAccess.setOutputPath(p1, 'src-gen/')
//            fileAccess.outputConfigurations.get(p1)?.setOverrideExistingResources(p2)
//        ]
        opt.getSet().getData().forEach [ String string |
            if(verbose) println("Processing " + string);
            // Load the resource
            val resourceSet = resourceSetProvider.get as XtextResourceSet
            resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
            val resource = resourceSet.getResource(URI.createFileURI(string), true)
            // Validate the resource
            val issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl)
            if (!issues.empty) {
                System.err.println("Error validating " + resource.URI)
                issues.forEach[System.err.println(it)]
                throw new ParseException("error validating " + resource.URI, issues.size)
            }

            val context = new RdlGeneratorContext => [cancelIndicator = CancelIndicator.NullImpl]
            context.forceOverwrite= opt.getSet().isSet('f')
            if(opt.getSet().isSet('n'))
                context.namespace=opt.getSet().getOption('n').getResultValue(0)
            generator.generate(resource, fileAccess, context)

            if(verbose) println('Code generation for ' + string + ' finished')
            try {
                if(verbose) println('includes are in ' + fileAccess.getURI('', 'incl-out'))
            } catch (Exception e) {
                println('includes are in ' + fileAccess.getURI(''))
            }
            try {
                if(verbose) println('sources are in  ' + fileAccess.getURI('', 'src-out'))
            } catch (Exception e) {
                println('sources are in  ' + fileAccess.getURI(''))
            }
        ]
    }
}
