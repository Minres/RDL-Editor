package com.minres.rdl.generator;

import com.google.common.base.Objects;
import com.minres.rdl.RdlUtil;
import com.minres.rdl.rdl.ComponentDefinition;
import com.minres.rdl.rdl.ComponentDefinitionType;
import com.minres.rdl.rdl.Instantiation;
import java.util.Iterator;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class ModuleGenerator extends RdlBaseGenerator {
  private final ComponentDefinition componentDefinition;
  
  public ModuleGenerator(final ComponentDefinition definition) {
    this.componentDefinition = definition;
  }
  
  @Override
  public boolean getOverwrite() {
    return false;
  }
  
  @Override
  public String generateHeader(final String namespace) {
    String _xblockexpression = null;
    {
      ComponentDefinitionType _type = this.componentDefinition.getType();
      boolean _notEquals = (!Objects.equal(_type, ComponentDefinitionType.REGFILE));
      if (_notEquals) {
        return "";
      }
      final Function1<Notifier, Boolean> _function = (Notifier it) -> {
        return Boolean.valueOf((it instanceof ComponentDefinition));
      };
      final Function1<Notifier, ComponentDefinition> _function_1 = (Notifier it) -> {
        return ((ComponentDefinition) it);
      };
      final Function1<ComponentDefinition, Boolean> _function_2 = (ComponentDefinition it) -> {
        ComponentDefinitionType _type_1 = it.getType();
        return Boolean.valueOf(Objects.equal(_type_1, ComponentDefinitionType.ADDRMAP));
      };
      final Function1<ComponentDefinition, Boolean> _function_3 = (ComponentDefinition def) -> {
        final Function1<Instantiation, Boolean> _function_4 = (Instantiation it) -> {
          ComponentDefinition _componentRef = it.getComponentRef();
          return Boolean.valueOf(Objects.equal(_componentRef, this.componentDefinition));
        };
        int _size = IterableExtensions.size(IterableExtensions.<Instantiation>filter(def.getInstantiations(), _function_4));
        return Boolean.valueOf((_size > 0));
      };
      final Iterator<ComponentDefinition> addrMaps = IteratorExtensions.<ComponentDefinition>filter(IteratorExtensions.<ComponentDefinition>filter(IteratorExtensions.<Notifier, ComponentDefinition>map(IteratorExtensions.<Notifier>filter(this.componentDefinition.eResource().getResourceSet().getAllContents(), _function), _function_1), _function_2), _function_3);
      int _size = IteratorExtensions.size(addrMaps);
      boolean _equals = (_size == 0);
      if (_equals) {
        return "";
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#ifndef _");
      String _upperCase = namespace.toUpperCase();
      _builder.append(_upperCase);
      _builder.append("_");
      String _upperCase_1 = RdlUtil.effectiveName(this.componentDefinition).toUpperCase();
      _builder.append(_upperCase_1);
      _builder.append("_H_");
      _builder.newLineIfNotEmpty();
      _builder.append("#define _");
      String _upperCase_2 = namespace.toUpperCase();
      _builder.append(_upperCase_2);
      _builder.append("_");
      String _upperCase_3 = RdlUtil.effectiveName(this.componentDefinition).toUpperCase();
      _builder.append(_upperCase_3);
      _builder.append("_H_");
      _builder.newLineIfNotEmpty();
      _builder.append("#include <scc/tlm_target.h>");
      _builder.newLine();
      _builder.newLine();
      _builder.append("namespace ");
      _builder.append(namespace);
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("namespace gen {");
      _builder.newLine();
      _builder.append("class ");
      String _effectiveName = RdlUtil.effectiveName(this.componentDefinition);
      _builder.append(_effectiveName);
      _builder.append("_regs;");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class ");
      String _effectiveName_1 = RdlUtil.effectiveName(this.componentDefinition);
      _builder.append(_effectiveName_1);
      _builder.append(" : public sc_core::sc_module, public scc::tlm_target<> {");
      _builder.newLineIfNotEmpty();
      _builder.append("public:");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("sc_core::sc_in<sc_core::sc_time> clk_i{\"clk_i\"};");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("sc_core::sc_in<bool> rst_i{\"rst_i\"};");
      _builder.newLine();
      _builder.append("    ");
      String _effectiveName_2 = RdlUtil.effectiveName(this.componentDefinition);
      _builder.append(_effectiveName_2, "    ");
      _builder.append("(sc_core::sc_module_name nm);");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("virtual ~");
      String _effectiveName_3 = RdlUtil.effectiveName(this.componentDefinition);
      _builder.append(_effectiveName_3, "    ");
      _builder.append("() override;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("protected:");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("void clock_cb();");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("void reset_cb();");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("sc_core::sc_time clk;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("std::unique_ptr<gen::");
      String _effectiveName_4 = RdlUtil.effectiveName(this.componentDefinition);
      _builder.append(_effectiveName_4, "    ");
      _builder.append("_regs> regs;");
      _builder.newLineIfNotEmpty();
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      _builder.append("} /* namespace ");
      _builder.append(namespace);
      _builder.append(" */");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#endif /* _");
      String _upperCase_4 = namespace.toUpperCase();
      _builder.append(_upperCase_4);
      _builder.append("_");
      String _upperCase_5 = RdlUtil.effectiveName(this.componentDefinition).toUpperCase();
      _builder.append(_upperCase_5);
      _builder.append("_H_ */");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  @Override
  public String generateSource(final String namespace) {
    String _xblockexpression = null;
    {
      ComponentDefinitionType _type = this.componentDefinition.getType();
      boolean _notEquals = (!Objects.equal(_type, ComponentDefinitionType.REGFILE));
      if (_notEquals) {
        return "";
      }
      final Function1<Notifier, Boolean> _function = (Notifier it) -> {
        return Boolean.valueOf((it instanceof ComponentDefinition));
      };
      final Function1<Notifier, ComponentDefinition> _function_1 = (Notifier it) -> {
        return ((ComponentDefinition) it);
      };
      final Function1<ComponentDefinition, Boolean> _function_2 = (ComponentDefinition it) -> {
        ComponentDefinitionType _type_1 = it.getType();
        return Boolean.valueOf(Objects.equal(_type_1, ComponentDefinitionType.ADDRMAP));
      };
      final Function1<ComponentDefinition, Boolean> _function_3 = (ComponentDefinition def) -> {
        final Function1<Instantiation, Boolean> _function_4 = (Instantiation it) -> {
          ComponentDefinition _componentRef = it.getComponentRef();
          return Boolean.valueOf(Objects.equal(_componentRef, this.componentDefinition));
        };
        int _size = IterableExtensions.size(IterableExtensions.<Instantiation>filter(def.getInstantiations(), _function_4));
        return Boolean.valueOf((_size > 0));
      };
      final Iterator<ComponentDefinition> addrMaps = IteratorExtensions.<ComponentDefinition>filter(IteratorExtensions.<ComponentDefinition>filter(IteratorExtensions.<Notifier, ComponentDefinition>map(IteratorExtensions.<Notifier>filter(this.componentDefinition.eResource().getResourceSet().getAllContents(), _function), _function_1), _function_2), _function_3);
      int _size = IteratorExtensions.size(addrMaps);
      boolean _equals = (_size == 0);
      if (_equals) {
        return "";
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Copyright (c) 2019 -2022 MINRES Technologies GmbH");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* SPDX-License-Identifier: Apache-2.0");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      _builder.append("#include \"");
      String _effectiveName = RdlUtil.effectiveName(this.componentDefinition);
      _builder.append(_effectiveName);
      _builder.append(".h\"");
      _builder.newLineIfNotEmpty();
      _builder.append("#include \"gen/");
      String _effectiveName_1 = RdlUtil.effectiveName(this.componentDefinition);
      _builder.append(_effectiveName_1);
      _builder.append(".h\"");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("#include <scc/utilities.h>");
      _builder.newLine();
      _builder.newLine();
      _builder.append("namespace ");
      _builder.append(namespace);
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("SC_HAS_PROCESS(");
      String _effectiveName_2 = RdlUtil.effectiveName(this.componentDefinition);
      _builder.append(_effectiveName_2);
      _builder.append(");// NOLINT");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      String _effectiveName_3 = RdlUtil.effectiveName(this.componentDefinition);
      _builder.append(_effectiveName_3);
      _builder.append("::");
      String _effectiveName_4 = RdlUtil.effectiveName(this.componentDefinition);
      _builder.append(_effectiveName_4);
      _builder.append("(sc_core::sc_module_name nm)");
      _builder.newLineIfNotEmpty();
      _builder.append(": sc_core::sc_module(nm)");
      _builder.newLine();
      _builder.append(", scc::tlm_target<>(clk)");
      _builder.newLine();
      _builder.append(", NAMEDD(regs, gen::");
      String _effectiveName_5 = RdlUtil.effectiveName(this.componentDefinition);
      _builder.append(_effectiveName_5);
      _builder.append("_regs) {");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("regs->registerResources(*this);");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("SC_METHOD(clock_cb);");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("sensitive << clk_i;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("SC_METHOD(reset_cb);");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("sensitive << rst_i;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      String _effectiveName_6 = RdlUtil.effectiveName(this.componentDefinition);
      _builder.append(_effectiveName_6);
      _builder.append("::~");
      String _effectiveName_7 = RdlUtil.effectiveName(this.componentDefinition);
      _builder.append(_effectiveName_7);
      _builder.append("() {} // NOLINT");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("void ");
      String _effectiveName_8 = RdlUtil.effectiveName(this.componentDefinition);
      _builder.append(_effectiveName_8);
      _builder.append("::clock_cb() { this->clk = clk_i.read(); }");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("void ");
      String _effectiveName_9 = RdlUtil.effectiveName(this.componentDefinition);
      _builder.append(_effectiveName_9);
      _builder.append("::reset_cb() {");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("if (rst_i.read()) {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("regs->reset_start();");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("regs->reset_stop();");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("} /* namespace ");
      _builder.append(namespace);
      _builder.append(" */");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
}
