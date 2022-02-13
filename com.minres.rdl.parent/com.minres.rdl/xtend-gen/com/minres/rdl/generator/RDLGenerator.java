/**
 * generated by Xtext 2.12.0
 */
package com.minres.rdl.generator;

import com.minres.rdl.RdlUtil;
import com.minres.rdl.rdl.ComponentDefinition;
import com.minres.rdl.rdl.ComponentDefinitionType;
import java.util.Collections;
import java.util.Map;
import java.util.function.BiConsumer;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class RDLGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    boolean _xifexpression = false;
    if ((context instanceof RdlGeneratorContext)) {
      _xifexpression = ((RdlGeneratorContext)context).forceOverwrite;
    } else {
      _xifexpression = false;
    }
    final boolean force = _xifexpression;
    String _xifexpression_1 = null;
    if ((context instanceof RdlGeneratorContext)) {
      _xifexpression_1 = ((RdlGeneratorContext)context).namespace;
    } else {
      _xifexpression_1 = "sysc";
    }
    final String namespace = _xifexpression_1;
    final Function1<Notifier, Boolean> _function = (Notifier it) -> {
      return Boolean.valueOf((it instanceof ComponentDefinition));
    };
    final Function1<Notifier, ComponentDefinition> _function_1 = (Notifier it) -> {
      return ((ComponentDefinition) it);
    };
    final Procedure1<ComponentDefinition> _function_2 = (ComponentDefinition it) -> {
      final Map<String, RdlBaseGenerator> genMap = this.fileGenerator(it);
      if ((genMap != null)) {
        final BiConsumer<String, RdlBaseGenerator> _function_3 = (String p1, RdlBaseGenerator gen) -> {
          final String header = gen.generateHeader(namespace);
          String _effectiveName = RdlUtil.effectiveName(it);
          String _plus = ((p1 + "/") + _effectiveName);
          final String inclFileName = (_plus + ".h");
          final String inclCfg = this.outputConfig(fsa, "incl-out");
          if (((((force || (!fsa.isFile(inclFileName, inclCfg))) || gen.getOverwrite()) && (header != null)) && (header.length() > 0))) {
            fsa.generateFile(inclFileName, inclCfg, header);
          }
          final String source = gen.generateSource(namespace);
          String _effectiveName_1 = RdlUtil.effectiveName(it);
          String _plus_1 = ((p1 + "/") + _effectiveName_1);
          final String srcFileName = (_plus_1 + ".cpp");
          final String srcCfg = this.outputConfig(fsa, "src-out");
          if (((((force || (!fsa.isFile(srcFileName, srcCfg))) || gen.getOverwrite()) && (source != null)) && (source.length() > 0))) {
            fsa.generateFile(srcFileName, srcCfg, source);
          }
        };
        genMap.forEach(_function_3);
      }
    };
    IteratorExtensions.<ComponentDefinition>forEach(IteratorExtensions.<Notifier, ComponentDefinition>map(IteratorExtensions.<Notifier>filter(resource.getResourceSet().getAllContents(), _function), _function_1), _function_2);
  }
  
  public Map<String, RdlBaseGenerator> fileGenerator(final ComponentDefinition definition) {
    Map<String, RdlBaseGenerator> _switchResult = null;
    ComponentDefinitionType _type = definition.getType();
    if (_type != null) {
      switch (_type) {
        case REGFILE:
          RegfileGenerator _regfileGenerator = new RegfileGenerator(definition);
          Pair<String, RegfileGenerator> _mappedTo = Pair.<String, RegfileGenerator>of("gen", _regfileGenerator);
          FwRegfileGenerator _fwRegfileGenerator = new FwRegfileGenerator(definition);
          Pair<String, FwRegfileGenerator> _mappedTo_1 = Pair.<String, FwRegfileGenerator>of("fw", _fwRegfileGenerator);
          ModuleGenerator _moduleGenerator = new ModuleGenerator(definition);
          Pair<String, ModuleGenerator> _mappedTo_2 = Pair.<String, ModuleGenerator>of(".", _moduleGenerator);
          _switchResult = Collections.<String, RdlBaseGenerator>unmodifiableMap(CollectionLiterals.<String, RdlBaseGenerator>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2));
          break;
        case ADDRMAP:
          AddrmapGenerator _addrmapGenerator = new AddrmapGenerator(definition);
          Pair<String, AddrmapGenerator> _mappedTo_3 = Pair.<String, AddrmapGenerator>of("gen", _addrmapGenerator);
          FwAddrmapGenerator _fwAddrmapGenerator = new FwAddrmapGenerator(definition);
          Pair<String, FwAddrmapGenerator> _mappedTo_4 = Pair.<String, FwAddrmapGenerator>of("fw", _fwAddrmapGenerator);
          _switchResult = Collections.<String, RdlBaseGenerator>unmodifiableMap(CollectionLiterals.<String, RdlBaseGenerator>newHashMap(_mappedTo_3, _mappedTo_4));
          break;
        default:
          _switchResult = null;
          break;
      }
    } else {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  public String outputConfig(final IFileSystemAccess2 fsa, final String string) {
    String output_config = string;
    try {
      fsa.getURI("", output_config);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        output_config = "DEFAULT_OUTPUT";
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return output_config;
  }
}
