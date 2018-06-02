package com.minres.rdl.generator;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.minres.rdl.RDLStandaloneSetup;
import com.minres.rdl.generator.Options;
import java.lang.reflect.MalformedParametersException;
import java.text.ParseException;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.utils.ProjectMapping;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class Main {
  private final String USAGE_STR = "RDL2code [-h] [-v] [-I <RDL include dir] [-o <output dir>] <input file> <input file>";
  
  public static void main(final String[] args) {
    boolean _isEmpty = ((List<String>)Conversions.doWrapArray(args)).isEmpty();
    if (_isEmpty) {
      System.err.println("Aborting: no path to RDL file provided!");
      return;
    }
    final Injector injector = new RDLStandaloneSetup().createInjectorAndDoEMFRegistration();
    final Main main = injector.<Main>getInstance(Main.class);
    try {
      main.run(args);
    } catch (final Throwable _t) {
      if (_t instanceof MalformedParametersException) {
        final MalformedParametersException e = (MalformedParametersException)_t;
        String _message = e.getMessage();
        String _plus = ("Command line error " + _message);
        InputOutput.<String>print(_plus);
        System.exit(1);
      } else if (_t instanceof IllegalArgumentException) {
        final IllegalArgumentException e_1 = (IllegalArgumentException)_t;
        String _message_1 = e_1.getMessage();
        String _plus_1 = ("generation error " + _message_1);
        InputOutput.<String>print(_plus_1);
        e_1.printStackTrace();
        System.exit(2);
      } else if (_t instanceof ParseException) {
        final ParseException e_2 = (ParseException)_t;
        String _message_2 = e_2.getMessage();
        String _plus_2 = ("parse problem " + _message_2);
        String _plus_3 = (_plus_2 + " (");
        int _errorOffset = e_2.getErrorOffset();
        String _plus_4 = (_plus_3 + Integer.valueOf(_errorOffset));
        String _plus_5 = (_plus_4 + ")");
        InputOutput.<String>print(_plus_5);
        System.exit(3);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Inject
  private Provider<ResourceSet> resourceSetProvider;
  
  @Inject
  private IResourceValidator validator;
  
  @Inject
  private GeneratorDelegate generator;
  
  @Inject
  private JavaIoFileSystemAccess fileAccess;
  
  public void run(final String[] args) {
    final Options opt = new Options(args, 0, Integer.MAX_VALUE);
    opt.getSet().addOption("h", Options.Multiplicity.ZERO_OR_ONE);
    opt.getSet().addOption("v", Options.Multiplicity.ZERO_OR_ONE);
    opt.getSet().addOption("o", Options.Separator.BLANK, Options.Multiplicity.ZERO_OR_ONE);
    opt.getSet().addOption("I", Options.Separator.BLANK, Options.Multiplicity.ZERO_OR_ONE);
    boolean _check = opt.check(false, false);
    boolean _not = (!_check);
    if (_not) {
      System.err.println(("Usage is: " + this.USAGE_STR));
      String _checkErrors = opt.getCheckErrors();
      throw new MalformedParametersException(_checkErrors);
    }
    boolean _isSet = opt.getSet().isSet("h");
    if (_isSet) {
      InputOutput.<String>println(("Usage: " + this.USAGE_STR));
      return;
    }
    boolean _xifexpression = false;
    boolean _isSet_1 = opt.getSet().isSet("v");
    if (_isSet_1) {
      _xifexpression = true;
    } else {
      _xifexpression = false;
    }
    final boolean verbose = _xifexpression;
    boolean _isSet_2 = opt.getSet().isSet("I");
    if (_isSet_2) {
      final ProjectMapping projectMapping = new ProjectMapping();
      projectMapping.setProjectName("RDL Repository");
      projectMapping.setPath(opt.getSet().getOption("I").getResultValue(0));
      new StandaloneSetup().addProjectMapping(projectMapping);
    }
    this.fileAccess.setOutputPath("src-gen/");
    boolean _isSet_3 = opt.getSet().isSet("o");
    if (_isSet_3) {
      this.fileAccess.setOutputPath(opt.getSet().getOption("o").getResultValue(0));
      OutputConfiguration _get = this.fileAccess.getOutputConfigurations().get(IFileSystemAccess.DEFAULT_OUTPUT);
      if (_get!=null) {
        _get.setOverrideExistingResources(true);
      }
    }
    final Consumer<String> _function = (String string) -> {
      try {
        if (verbose) {
          InputOutput.<String>println(("Processing " + string));
        }
        ResourceSet _get_1 = this.resourceSetProvider.get();
        final XtextResourceSet resourceSet = ((XtextResourceSet) _get_1);
        resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
        final Resource resource = resourceSet.getResource(URI.createFileURI(string), true);
        final List<Issue> issues = this.validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
        boolean _isEmpty = issues.isEmpty();
        boolean _not_1 = (!_isEmpty);
        if (_not_1) {
          URI _uRI = resource.getURI();
          String _plus = ("Error validating " + _uRI);
          System.err.println(_plus);
          final Consumer<Issue> _function_1 = (Issue it) -> {
            System.err.println(it);
          };
          issues.forEach(_function_1);
          URI _uRI_1 = resource.getURI();
          String _plus_1 = ("error validating " + _uRI_1);
          int _size = issues.size();
          throw new ParseException(_plus_1, _size);
        }
        GeneratorContext _generatorContext = new GeneratorContext();
        final Procedure1<GeneratorContext> _function_2 = (GeneratorContext it) -> {
          it.setCancelIndicator(CancelIndicator.NullImpl);
        };
        final GeneratorContext context = ObjectExtensions.<GeneratorContext>operator_doubleArrow(_generatorContext, _function_2);
        this.generator.generate(resource, this.fileAccess, context);
        if (verbose) {
          InputOutput.<String>println((("Code generation for " + string) + " finished"));
        }
        try {
          if (verbose) {
            URI _uRI_2 = this.fileAccess.getURI("", "incl-out");
            String _plus_2 = ("includes are in " + _uRI_2);
            InputOutput.<String>println(_plus_2);
          }
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            URI _uRI_3 = this.fileAccess.getURI("");
            String _plus_3 = ("includes are in " + _uRI_3);
            InputOutput.<String>println(_plus_3);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        try {
          if (verbose) {
            URI _uRI_4 = this.fileAccess.getURI("", "src-out");
            String _plus_4 = ("sources are in  " + _uRI_4);
            InputOutput.<String>println(_plus_4);
          }
        } catch (final Throwable _t_1) {
          if (_t_1 instanceof Exception) {
            URI _uRI_5 = this.fileAccess.getURI("");
            String _plus_5 = ("sources are in  " + _uRI_5);
            InputOutput.<String>println(_plus_5);
          } else {
            throw Exceptions.sneakyThrow(_t_1);
          }
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    opt.getSet().getData().forEach(_function);
  }
}
