package com.minres.rdl.generator


import com.google.inject.Inject
import com.google.inject.Provider
import com.minres.rdl.RDLStandaloneSetup
import java.lang.reflect.MalformedParametersException
import java.util.ArrayList
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

class Main {
     static class Option {
         String flag
         String value
         def Option(String flag, String value) { 
            this.flag = flag
            this.value = value
         }
    }

    def static main(String[] args) {
        if (args.empty) {
            System::err.println('Aborting: no path to EMF resource provided!')
            return
        }
                
        try { 
            val injector = new RDLStandaloneSetup().createInjectorAndDoEMFRegistration
            injector.getInstance(Main).run(args)
        } catch(MalformedParametersException e){
            print("Command line error "+e.message)
        } catch(IllegalArgumentException e){
            print("generation error "+e.message)
            e.printStackTrace
        } catch(ParseException e){
            print("parse problem "+e.message+" ("+ e.errorOffset+")")
            
        }
    }

    @Inject Provider<ResourceSet> resourceSetProvider

    @Inject IResourceValidator validator

    @Inject GeneratorDelegate generator

    @Inject JavaIoFileSystemAccess fileAccess

    var optsList = new ArrayList<Option>();
    var argsList = new ArrayList<String>()  
    val shortOptMap = newLinkedHashMap('i' -> 'incl-out', 's' -> 'src-out')

    def protected parseOptions(String[] args) {
        for (arg : args) {
            switch (arg) {
                case arg.startsWith('--'): {
                    if (arg.length < 3)
                        throw new MalformedParametersException("not a valid argument: " + arg);
                    val res = arg.substring(2).split('=')
                    var opt = new Option()
                    val longOpt = shortOptMap.values.findFirst[String s|s == res.get(0)]
                    if(longOpt === null) throw new IllegalArgumentException("unknown option: " + arg);
                    opt.flag = res.get(0)
                    if (res.size == 2)
                        opt.value = res.get(1)
                    optsList += opt
                }
                case arg.startsWith('-'): {
                    if (arg.length < 2)
                        throw new MalformedParametersException("not a valid argument: " + arg);
                    // -opt
                    var res = arg.substring(1).split('=')
                    val longOpt = shortOptMap.get(res.get(0))
                    if(longOpt === null) throw new MalformedParametersException("unknown option: " + arg);
                    var opt = new Option()
                    opt.flag = longOpt
                    if (res.size == 2)
                        opt.value = res.get(1)
                    optsList += opt

                }
                default: {
                    argsList += arg;
                }
            }
        }

    }
    
    def run(String[] args){
        parseOptions(args)
        val repo = optsList.findFirst[it.flag == "repository"]
        if(repo!==null){
            val projectMapping = new ProjectMapping
            projectMapping.projectName = "RDL Repository"
            projectMapping.path = repo.value
            new StandaloneSetup().addProjectMapping(projectMapping)
        }
        argsList.forEach[runGenerator(it)]
    }
    
    def protected runGenerator(String string) {
        // Load the resource
        val resourceSet = resourceSetProvider.get as XtextResourceSet
        resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
        val resource = resourceSet.getResource(URI.createFileURI(string), true)
        // Validate the resource
        val issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl)
        if (!issues.empty) {
            System.err.println("Error validating "+resource.URI)
            issues.forEach[System.err.println(it)]
            throw new ParseException("error validating "+resource.URI, issues.size)
        }
        // Configure and start the generator
        fileAccess.outputPath = 'src-gen/'
        optsList.filter[it.flag.matches('.*-out')].forEach[fileAccess.setOutputPath(it.flag, it.value)]
        fileAccess.outputConfigurations.get('src-out')?.setOverrideExistingResources(true)
        
        val context = new GeneratorContext => [ cancelIndicator = CancelIndicator.NullImpl ]
        generator.generate(resource, fileAccess, context)
        
        System.out.print('Code generation for '+string +' finished, ')
        try{
            System.out.print('includes are in '+fileAccess.getURI('', 'incl-out')+', ')
        }catch(Exception e){
            System.out.print('includes are in '+fileAccess.getURI('')+', ')         
        }
        try{
            System.out.println('sources are in '+fileAccess.getURI('', 'src-out')+', ')
        }catch(Exception e){
            System.out.println('sources are in '+fileAccess.getURI('')+', ')            
        }
    }
}
