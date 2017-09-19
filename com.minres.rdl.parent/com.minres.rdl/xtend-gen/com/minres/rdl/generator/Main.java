package com.minres.rdl.generator;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.minres.rdl.RDLStandaloneSetup;
import java.lang.reflect.MalformedParametersException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.utils.ProjectMapping;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class Main {
  public static class Option {
    private String flag;
    
    private String value;
    
    public String Option(final String flag, final String value) {
      String _xblockexpression = null;
      {
        this.flag = flag;
        _xblockexpression = this.value = value;
      }
      return _xblockexpression;
    }
  }
  
  public static void main(final String[] args) {
    boolean _isEmpty = ((List<String>)Conversions.doWrapArray(args)).isEmpty();
    if (_isEmpty) {
      System.err.println("Aborting: no path to EMF resource provided!");
      return;
    }
    try {
      final Injector injector = new RDLStandaloneSetup().createInjectorAndDoEMFRegistration();
      injector.<Main>getInstance(Main.class).run(args);
    } catch (final Throwable _t) {
      if (_t instanceof MalformedParametersException) {
        final MalformedParametersException e = (MalformedParametersException)_t;
        String _message = e.getMessage();
        String _plus = ("Command line error " + _message);
        InputOutput.<String>print(_plus);
      } else if (_t instanceof IllegalArgumentException) {
        final IllegalArgumentException e_1 = (IllegalArgumentException)_t;
        String _message_1 = e_1.getMessage();
        String _plus_1 = ("generation error " + _message_1);
        InputOutput.<String>print(_plus_1);
        e_1.printStackTrace();
      } else if (_t instanceof ParseException) {
        final ParseException e_2 = (ParseException)_t;
        String _message_2 = e_2.getMessage();
        String _plus_2 = ("parse problem " + _message_2);
        String _plus_3 = (_plus_2 + " (");
        int _errorOffset = e_2.getErrorOffset();
        String _plus_4 = (_plus_3 + Integer.valueOf(_errorOffset));
        String _plus_5 = (_plus_4 + ")");
        InputOutput.<String>print(_plus_5);
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
  
  private ArrayList<Main.Option> optsList = new ArrayList<Main.Option>();
  
  private ArrayList<String> argsList = new ArrayList<String>();
  
  private final LinkedHashMap<String, String> shortOptMap = CollectionLiterals.<String, String>newLinkedHashMap(Pair.<String, String>of("i", "incl-out"), Pair.<String, String>of("s", "src-out"));
  
  protected void parseOptions(final String[] args) {
    for (final String arg : args) {
      boolean _matched = false;
      boolean _startsWith = arg.startsWith("--");
      if (_startsWith) {
        _matched=true;
        int _length = arg.length();
        boolean _lessThan = (_length < 3);
        if (_lessThan) {
          throw new MalformedParametersException(("not a valid argument: " + arg));
        }
        final String[] res = arg.substring(2).split("=");
        Main.Option opt = new Main.Option();
        final Function1<String, Boolean> _function = (String s) -> {
          Object _get = res[0];
          return Boolean.valueOf(Objects.equal(s, _get));
        };
        final String longOpt = IterableExtensions.<String>findFirst(this.shortOptMap.values(), _function);
        if ((longOpt == null)) {
          throw new IllegalArgumentException(("unknown option: " + arg));
        }
        opt.flag = res[0];
        int _size = ((List<String>)Conversions.doWrapArray(res)).size();
        boolean _equals = (_size == 2);
        if (_equals) {
          opt.value = res[1];
        }
        this.optsList.add(opt);
      }
      if (!_matched) {
        boolean _startsWith_1 = arg.startsWith("-");
        if (_startsWith_1) {
          _matched=true;
          int _length_1 = arg.length();
          boolean _lessThan_1 = (_length_1 < 2);
          if (_lessThan_1) {
            throw new MalformedParametersException(("not a valid argument: " + arg));
          }
          String[] res_1 = arg.substring(1).split("=");
          final String longOpt_1 = this.shortOptMap.get(res_1[0]);
          if ((longOpt_1 == null)) {
            throw new MalformedParametersException(("unknown option: " + arg));
          }
          Main.Option opt_1 = new Main.Option();
          opt_1.flag = longOpt_1;
          final String[] _converted_res_1 = (String[])res_1;
          int _size_1 = ((List<String>)Conversions.doWrapArray(_converted_res_1)).size();
          boolean _equals_1 = (_size_1 == 2);
          if (_equals_1) {
            opt_1.value = res_1[1];
          }
          this.optsList.add(opt_1);
        }
      }
      if (!_matched) {
        this.argsList.add(arg);
      }
    }
  }
  
  public void run(final String[] args) {
    this.parseOptions(args);
    final Function1<Main.Option, Boolean> _function = (Main.Option it) -> {
      return Boolean.valueOf(Objects.equal(it.flag, "repository"));
    };
    final Main.Option repo = IterableExtensions.<Main.Option>findFirst(this.optsList, _function);
    if ((repo != null)) {
      final ProjectMapping projectMapping = new ProjectMapping();
      projectMapping.setProjectName("RDL Repository");
      projectMapping.setPath(repo.value);
      new StandaloneSetup().addProjectMapping(projectMapping);
    }
    final Consumer<String> _function_1 = (String it) -> {
      this.runGenerator(it);
    };
    this.argsList.forEach(_function_1);
  }
  
  protected void runGenerator(final String string) {
    try {
      ResourceSet _get = this.resourceSetProvider.get();
      final XtextResourceSet resourceSet = ((XtextResourceSet) _get);
      resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
      final Resource resource = resourceSet.getResource(URI.createFileURI(string), true);
      final List<Issue> issues = this.validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
      boolean _isEmpty = issues.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        URI _uRI = resource.getURI();
        String _plus = ("Error validating " + _uRI);
        System.err.println(_plus);
        final Consumer<Issue> _function = (Issue it) -> {
          System.err.println(it);
        };
        issues.forEach(_function);
        URI _uRI_1 = resource.getURI();
        String _plus_1 = ("error validating " + _uRI_1);
        int _size = issues.size();
        throw new ParseException(_plus_1, _size);
      }
      this.fileAccess.setOutputPath("src-gen/");
      final Function1<Main.Option, Boolean> _function_1 = (Main.Option it) -> {
        return Boolean.valueOf(it.flag.matches(".*-out"));
      };
      final Consumer<Main.Option> _function_2 = (Main.Option it) -> {
        this.fileAccess.setOutputPath(it.flag, it.value);
      };
      IterableExtensions.<Main.Option>filter(this.optsList, _function_1).forEach(_function_2);
      OutputConfiguration _get_1 = this.fileAccess.getOutputConfigurations().get("src-out");
      if (_get_1!=null) {
        _get_1.setOverrideExistingResources(true);
      }
      GeneratorContext _generatorContext = new GeneratorContext();
      final Procedure1<GeneratorContext> _function_3 = (GeneratorContext it) -> {
        it.setCancelIndicator(CancelIndicator.NullImpl);
      };
      final GeneratorContext context = ObjectExtensions.<GeneratorContext>operator_doubleArrow(_generatorContext, _function_3);
      this.generator.generate(resource, this.fileAccess, context);
      System.out.print((("Code generation for " + string) + " finished, "));
      try {
        URI _uRI_2 = this.fileAccess.getURI("", "incl-out");
        String _plus_2 = ("includes are in " + _uRI_2);
        String _plus_3 = (_plus_2 + ", ");
        System.out.print(_plus_3);
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          URI _uRI_3 = this.fileAccess.getURI("");
          String _plus_4 = ("includes are in " + _uRI_3);
          String _plus_5 = (_plus_4 + ", ");
          System.out.print(_plus_5);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      try {
        URI _uRI_4 = this.fileAccess.getURI("", "src-out");
        String _plus_6 = ("sources are in " + _uRI_4);
        String _plus_7 = (_plus_6 + ", ");
        System.out.println(_plus_7);
      } catch (final Throwable _t_1) {
        if (_t_1 instanceof Exception) {
          final Exception e_1 = (Exception)_t_1;
          URI _uRI_5 = this.fileAccess.getURI("");
          String _plus_8 = ("sources are in " + _uRI_5);
          String _plus_9 = (_plus_8 + ", ");
          System.out.println(_plus_9);
        } else {
          throw Exceptions.sneakyThrow(_t_1);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
