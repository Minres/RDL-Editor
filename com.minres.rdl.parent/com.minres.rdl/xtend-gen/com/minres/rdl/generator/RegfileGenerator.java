package com.minres.rdl.generator;

import com.google.common.base.Objects;
import com.minres.rdl.IntegerWithRadix;
import com.minres.rdl.RdlUtil;
import com.minres.rdl.rdl.ComponentDefinition;
import com.minres.rdl.rdl.ComponentDefinitionType;
import com.minres.rdl.rdl.ComponentInstance;
import com.minres.rdl.rdl.Instantiation;
import com.minres.rdl.rdl.Range;
import java.util.Date;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class RegfileGenerator extends RdlBaseGenerator {
  private final ComponentDefinition componentDefinition;
  
  public RegfileGenerator(final ComponentDefinition definition) {
    this.componentDefinition = definition;
  }
  
  @Override
  public boolean getOverwrite() {
    return true;
  }
  
  @Override
  public String generateHeader(final String namespace) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("////////////////////////////////////////////////////////////////////////////////");
    _builder.newLine();
    _builder.append("// Copyright (C) 2017-2022, MINRES Technologies GmbH");
    _builder.newLine();
    _builder.append("// All rights reserved.");
    _builder.newLine();
    _builder.append("//");
    _builder.newLine();
    _builder.append("// Redistribution and use in source and binary forms, with or without");
    _builder.newLine();
    _builder.append("// modification, are permitted provided that the following conditions are met:");
    _builder.newLine();
    _builder.append("//");
    _builder.newLine();
    _builder.append("// 1. Redistributions of source code must retain the above copyright notice,");
    _builder.newLine();
    _builder.append("//    this list of conditions and the following disclaimer.");
    _builder.newLine();
    _builder.append("//");
    _builder.newLine();
    _builder.append("// 2. Redistributions in binary form must reproduce the above copyright notice,");
    _builder.newLine();
    _builder.append("//    this list of conditions and the following disclaimer in the documentation");
    _builder.newLine();
    _builder.append("//    and/or other materials provided with the distribution.");
    _builder.newLine();
    _builder.append("//");
    _builder.newLine();
    _builder.append("// 3. Neither the name of the copyright holder nor the names of its contributors");
    _builder.newLine();
    _builder.append("//    may be used to endorse or promote products derived from this software");
    _builder.newLine();
    _builder.append("//    without specific prior written permission.");
    _builder.newLine();
    _builder.append("//");
    _builder.newLine();
    _builder.append("// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\"");
    _builder.newLine();
    _builder.append("// AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE");
    _builder.newLine();
    _builder.append("// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE");
    _builder.newLine();
    _builder.append("// ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE");
    _builder.newLine();
    _builder.append("// LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR");
    _builder.newLine();
    _builder.append("// CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF");
    _builder.newLine();
    _builder.append("// SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS");
    _builder.newLine();
    _builder.append("// INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN");
    _builder.newLine();
    _builder.append("// CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)");
    _builder.newLine();
    _builder.append("// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE");
    _builder.newLine();
    _builder.append("// POSSIBILITY OF SUCH DAMAGE.");
    _builder.newLine();
    _builder.append("//");
    _builder.newLine();
    _builder.append("// Created on: ");
    Date _date = new Date();
    _builder.append(_date);
    _builder.newLineIfNotEmpty();
    _builder.append("//             *      ");
    String _effectiveName = RdlUtil.effectiveName(this.componentDefinition);
    _builder.append(_effectiveName);
    _builder.append(".h Author: <RDL Generator>");
    _builder.newLineIfNotEmpty();
    _builder.append("//");
    _builder.newLine();
    _builder.append("////////////////////////////////////////////////////////////////////////////////");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#ifndef _");
    String _upperCase = namespace.toUpperCase();
    _builder.append(_upperCase);
    _builder.append("_GEN_");
    String _upperCase_1 = RdlUtil.effectiveName(this.componentDefinition).toUpperCase();
    _builder.append(_upperCase_1);
    _builder.append("_H_");
    _builder.newLineIfNotEmpty();
    _builder.append("#define _");
    String _upperCase_2 = namespace.toUpperCase();
    _builder.append(_upperCase_2);
    _builder.append("_GEN_");
    String _upperCase_3 = RdlUtil.effectiveName(this.componentDefinition).toUpperCase();
    _builder.append(_upperCase_3);
    _builder.append("_H_");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include <scc/utilities.h>");
    _builder.newLine();
    _builder.append("#include <util/bit_field.h>");
    _builder.newLine();
    _builder.append("#include <scc/register.h>");
    _builder.newLine();
    _builder.append("#include <scc/tlm_target.h>");
    _builder.newLine();
    {
      EList<Instantiation> _instantiations = this.componentDefinition.getInstantiations();
      for(final Instantiation instantiation : _instantiations) {
        {
          ComponentDefinitionType _type = RdlUtil.getComponentDefinition(instantiation).getType();
          boolean _equals = Objects.equal(_type, ComponentDefinitionType.REGFILE);
          if (_equals) {
            _builder.append("#include \"");
            String _effectiveName_1 = RdlUtil.effectiveName(RdlUtil.getComponentDefinition(instantiation));
            _builder.append(_effectiveName_1);
            _builder.append(".h\"");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("namespace ");
    _builder.append(namespace);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("namespace gen {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    String _effectiveName_2 = RdlUtil.effectiveName(this.componentDefinition);
    _builder.append(_effectiveName_2);
    _builder.append("_regs :");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("public sc_core::sc_module,");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public scc::resetable");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("public:");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("//////////////////////////////////////////////////////////////////////////////");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// storage declarations");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("//////////////////////////////////////////////////////////////////////////////");
    _builder.newLine();
    {
      EList<ComponentDefinition> _componentDefinitions = this.componentDefinition.getComponentDefinitions();
      for(final ComponentDefinition cdef : _componentDefinitions) {
        {
          ComponentDefinitionType _type_1 = cdef.getType();
          boolean _equals_1 = Objects.equal(_type_1, ComponentDefinitionType.REG);
          if (_equals_1) {
            _builder.append("    ");
            _builder.append("BEGIN_BF_DECL(");
            String _effectiveName_3 = RdlUtil.effectiveName(cdef);
            _builder.append(_effectiveName_3, "    ");
            _builder.append("+\'_t\'», uint");
            _builder.append(cdef, "    ");
            _builder.append("_t);");
            _builder.newLineIfNotEmpty();
            _builder.append("    ");
            String _genFieldDeclarations = this.genFieldDeclarations(cdef);
            _builder.append(_genFieldDeclarations, "    ");
            _builder.newLineIfNotEmpty();
            _builder.append("    ");
            _builder.append("END_BF_DECL();");
            _builder.newLine();
          }
        }
      }
    }
    {
      EList<Instantiation> _instantiations_1 = this.componentDefinition.getInstantiations();
      for(final Instantiation instantiation_1 : _instantiations_1) {
        {
          ComponentDefinitionType _type_2 = RdlUtil.getComponentDefinition(instantiation_1).getType();
          boolean _equals_2 = Objects.equal(_type_2, ComponentDefinitionType.REGFILE);
          if (_equals_2) {
            {
              EList<ComponentInstance> _componentInstances = instantiation_1.getComponentInstances();
              for(final ComponentInstance instance : _componentInstances) {
                _builder.append("    ");
                String _effectiveName_4 = RdlUtil.effectiveName(RdlUtil.getComponentDefinition(instantiation_1));
                _builder.append(_effectiveName_4, "    ");
                _builder.append("_regs i_");
                String _name = instance.getName();
                _builder.append(_name, "    ");
                _builder.append("{\"");
                String _name_1 = instance.getName();
                _builder.append(_name_1, "    ");
                _builder.append("\"};");
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            ComponentDefinitionType _type_3 = RdlUtil.getComponentDefinition(instantiation_1).getType();
            boolean _equals_3 = Objects.equal(_type_3, ComponentDefinitionType.REG);
            if (_equals_3) {
              {
                boolean _isFilledByField = RdlUtil.isFilledByField(instantiation_1);
                if (_isFilledByField) {
                  {
                    final Function1<ComponentInstance, Boolean> _function = (ComponentInstance it) -> {
                      Range _range = it.getRange();
                      return Boolean.valueOf((_range == null));
                    };
                    int _size = IterableExtensions.size(IterableExtensions.<ComponentInstance>filter(instantiation_1.getComponentInstances(), _function));
                    boolean _greaterThan = (_size > 0);
                    if (_greaterThan) {
                      _builder.append("    ");
                      _builder.append("uint");
                      long _size_1 = RdlUtil.getSize(instantiation_1);
                      _builder.append(_size_1, "    ");
                      _builder.append("_t ");
                      final Function1<ComponentInstance, Boolean> _function_1 = (ComponentInstance it) -> {
                        Range _range = it.getRange();
                        return Boolean.valueOf((_range == null));
                      };
                      final Function1<ComponentInstance, String> _function_2 = (ComponentInstance it) -> {
                        String _name_2 = it.getName();
                        return ("r_" + _name_2);
                      };
                      String _join = IterableExtensions.join(IterableExtensions.<ComponentInstance, String>map(IterableExtensions.<ComponentInstance>filter(instantiation_1.getComponentInstances(), _function_1), _function_2), ", ");
                      _builder.append(_join, "    ");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  {
                    final Function1<ComponentInstance, Boolean> _function_3 = (ComponentInstance it) -> {
                      Range _range = it.getRange();
                      return Boolean.valueOf((_range != null));
                    };
                    Iterable<ComponentInstance> _filter = IterableExtensions.<ComponentInstance>filter(instantiation_1.getComponentInstances(), _function_3);
                    for(final ComponentInstance componentInstance : _filter) {
                      _builder.append("    ");
                      _builder.append("std::array<uint");
                      long _size_2 = RdlUtil.getSize(instantiation_1);
                      _builder.append(_size_2, "    ");
                      _builder.append("_t, ");
                      long _absSize = RdlUtil.absSize(componentInstance.getRange());
                      _builder.append(_absSize, "    ");
                      _builder.append("> r_");
                      String _name_2 = componentInstance.getName();
                      _builder.append(_name_2, "    ");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                } else {
                  int _size_3 = RdlUtil.getComponentDefinition(instantiation_1).getInstantiations().size();
                  boolean _equals_4 = (_size_3 == 0);
                  if (_equals_4) {
                    {
                      final Function1<ComponentInstance, Boolean> _function_4 = (ComponentInstance it) -> {
                        Range _range = it.getRange();
                        return Boolean.valueOf((_range == null));
                      };
                      int _size_4 = IterableExtensions.size(IterableExtensions.<ComponentInstance>filter(instantiation_1.getComponentInstances(), _function_4));
                      boolean _greaterThan_1 = (_size_4 > 0);
                      if (_greaterThan_1) {
                        _builder.append("    ");
                        _builder.append("uint");
                        long _size_5 = RdlUtil.getSize(instantiation_1);
                        _builder.append(_size_5, "    ");
                        _builder.append("_t ");
                        final Function1<ComponentInstance, Boolean> _function_5 = (ComponentInstance it) -> {
                          Range _range = it.getRange();
                          return Boolean.valueOf((_range == null));
                        };
                        final Function1<ComponentInstance, String> _function_6 = (ComponentInstance it) -> {
                          String _name_3 = it.getName();
                          return ("r_" + _name_3);
                        };
                        String _join_1 = IterableExtensions.join(IterableExtensions.<ComponentInstance, String>map(IterableExtensions.<ComponentInstance>filter(instantiation_1.getComponentInstances(), _function_5), _function_6), ", ");
                        _builder.append(_join_1, "    ");
                        _builder.append(";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    {
                      final Function1<ComponentInstance, Boolean> _function_7 = (ComponentInstance it) -> {
                        Range _range = it.getRange();
                        return Boolean.valueOf((_range != null));
                      };
                      Iterable<ComponentInstance> _filter_1 = IterableExtensions.<ComponentInstance>filter(instantiation_1.getComponentInstances(), _function_7);
                      for(final ComponentInstance componentInstance_1 : _filter_1) {
                        _builder.append("    ");
                        _builder.append("std::array<uint");
                        long _size_6 = RdlUtil.getSize(instantiation_1);
                        _builder.append(_size_6, "    ");
                        _builder.append("_t, ");
                        long _absSize_1 = RdlUtil.absSize(componentInstance_1.getRange());
                        _builder.append(_absSize_1, "    ");
                        _builder.append("> r_");
                        String _name_3 = componentInstance_1.getName();
                        _builder.append(_name_3, "    ");
                        _builder.append(";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  } else {
                    _builder.append("    ");
                    _builder.append("BEGIN_BF_DECL(");
                    String _effectiveName_5 = RdlUtil.effectiveName(instantiation_1.getComponent());
                    _builder.append(_effectiveName_5, "    ");
                    _builder.append("_t, uint");
                    long _size_7 = RdlUtil.getSize(instantiation_1);
                    _builder.append(_size_7, "    ");
                    _builder.append("_t);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("    ");
                    _builder.append("    ");
                    String _genFieldDeclarations_1 = this.genFieldDeclarations(RdlUtil.definingComponent(instantiation_1));
                    _builder.append(_genFieldDeclarations_1, "        ");
                    _builder.newLineIfNotEmpty();
                    _builder.append("    ");
                    _builder.append("END_BF_DECL() ");
                    final Function1<ComponentInstance, Boolean> _function_8 = (ComponentInstance it) -> {
                      Range _range = it.getRange();
                      return Boolean.valueOf((_range == null));
                    };
                    final Function1<ComponentInstance, String> _function_9 = (ComponentInstance it) -> {
                      String _name_4 = it.getName();
                      return ("r_" + _name_4);
                    };
                    String _join_2 = IterableExtensions.join(IterableExtensions.<ComponentInstance, String>map(IterableExtensions.<ComponentInstance>filter(instantiation_1.getComponentInstances(), _function_8), _function_9), ", ");
                    _builder.append(_join_2, "    ");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                    {
                      final Function1<ComponentInstance, Boolean> _function_10 = (ComponentInstance it) -> {
                        Range _range = it.getRange();
                        return Boolean.valueOf((_range != null));
                      };
                      Iterable<ComponentInstance> _filter_2 = IterableExtensions.<ComponentInstance>filter(instantiation_1.getComponentInstances(), _function_10);
                      for(final ComponentInstance componentInstance_2 : _filter_2) {
                        _builder.append("    ");
                        _builder.append("std::array<");
                        String _effectiveName_6 = RdlUtil.effectiveName(instantiation_1.getComponent());
                        _builder.append(_effectiveName_6, "    ");
                        _builder.append("_t, ");
                        long _absSize_2 = RdlUtil.absSize(componentInstance_2.getRange());
                        _builder.append(_absSize_2, "    ");
                        _builder.append("> r_");
                        String _name_4 = componentInstance_2.getName();
                        _builder.append(_name_4, "    ");
                        _builder.append(";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    _builder.append("    ");
    _builder.append("//////////////////////////////////////////////////////////////////////////////");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// register declarations");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("//////////////////////////////////////////////////////////////////////////////");
    _builder.newLine();
    {
      EList<Instantiation> _instantiations_2 = this.componentDefinition.getInstantiations();
      for(final Instantiation instantiation_2 : _instantiations_2) {
        {
          EList<ComponentInstance> _componentInstances_1 = instantiation_2.getComponentInstances();
          for(final ComponentInstance instance_1 : _componentInstances_1) {
            {
              ComponentDefinitionType _type_4 = RdlUtil.getComponentDefinition(instantiation_2).getType();
              boolean _equals_5 = Objects.equal(_type_4, ComponentDefinitionType.REGFILE);
              if (_equals_5) {
                _builder.append("    ");
                _builder.append("// scc::sc_register_file<");
                String _effectiveName_7 = RdlUtil.effectiveName(RdlUtil.getComponentDefinition(instantiation_2));
                _builder.append(_effectiveName_7, "    ");
                _builder.append("_regs> ");
                String _name_5 = instance_1.getName();
                _builder.append(_name_5, "    ");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              } else {
                ComponentDefinitionType _type_5 = RdlUtil.getComponentDefinition(instantiation_2).getType();
                boolean _equals_6 = Objects.equal(_type_5, ComponentDefinitionType.REG);
                if (_equals_6) {
                  {
                    Range _range = instance_1.getRange();
                    boolean _tripleEquals = (_range == null);
                    if (_tripleEquals) {
                      {
                        int _size_8 = RdlUtil.getComponentDefinition(instantiation_2).getInstantiations().size();
                        boolean _equals_7 = (_size_8 == 0);
                        if (_equals_7) {
                          _builder.append("    ");
                          _builder.append("scc::sc_register<uint");
                          long _size_9 = RdlUtil.getSize(instantiation_2);
                          _builder.append(_size_9, "    ");
                          _builder.append("_t> ");
                          String _name_6 = instance_1.getName();
                          _builder.append(_name_6, "    ");
                          _builder.append(";");
                          _builder.newLineIfNotEmpty();
                        } else {
                          boolean _isFilledByField_1 = RdlUtil.isFilledByField(instantiation_2);
                          if (_isFilledByField_1) {
                            _builder.append("    ");
                            _builder.append("scc::sc_register<uint");
                            long _size_10 = RdlUtil.getSize(instantiation_2);
                            _builder.append(_size_10, "    ");
                            _builder.append("_t> ");
                            String _name_7 = instance_1.getName();
                            _builder.append(_name_7, "    ");
                            _builder.append(";");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("    ");
                            _builder.append("scc::sc_register<");
                            String _effectiveName_8 = RdlUtil.effectiveName(RdlUtil.getComponentDefinition(instantiation_2));
                            _builder.append(_effectiveName_8, "    ");
                            _builder.append("_t> ");
                            String _name_8 = instance_1.getName();
                            _builder.append(_name_8, "    ");
                            _builder.append(";");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    } else {
                      {
                        int _size_11 = RdlUtil.getComponentDefinition(instantiation_2).getInstantiations().size();
                        boolean _equals_8 = (_size_11 == 0);
                        if (_equals_8) {
                          _builder.append("    ");
                          _builder.append("scc::sc_register_indexed<uint");
                          long _size_12 = RdlUtil.getSize(instantiation_2);
                          _builder.append(_size_12, "    ");
                          _builder.append("_t, ");
                          long _absSize_3 = RdlUtil.absSize(instance_1.getRange());
                          _builder.append(_absSize_3, "    ");
                          _builder.append("> ");
                          String _name_9 = instance_1.getName();
                          _builder.append(_name_9, "    ");
                          _builder.append(";");
                          _builder.newLineIfNotEmpty();
                        } else {
                          boolean _isFilledByField_2 = RdlUtil.isFilledByField(instantiation_2);
                          if (_isFilledByField_2) {
                            _builder.append("    ");
                            _builder.append("scc::sc_register_indexed<uint");
                            long _size_13 = RdlUtil.getSize(instantiation_2);
                            _builder.append(_size_13, "    ");
                            _builder.append("_t, ");
                            long _absSize_4 = RdlUtil.absSize(instance_1.getRange());
                            _builder.append(_absSize_4, "    ");
                            _builder.append("> ");
                            String _name_10 = instance_1.getName();
                            _builder.append(_name_10, "    ");
                            _builder.append(";");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("    ");
                            _builder.append("scc::sc_register_indexed<");
                            String _effectiveName_9 = RdlUtil.effectiveName(instantiation_2.getComponent());
                            _builder.append(_effectiveName_9, "    ");
                            _builder.append("_t, ");
                            long _absSize_5 = RdlUtil.absSize(instance_1.getRange());
                            _builder.append(_absSize_5, "    ");
                            _builder.append("> ");
                            String _name_11 = instance_1.getName();
                            _builder.append(_name_11, "    ");
                            _builder.append(";");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    String _effectiveName_10 = RdlUtil.effectiveName(this.componentDefinition);
    _builder.append(_effectiveName_10, "    ");
    _builder.append("_regs(sc_core::sc_module_name nm);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("template<unsigned BUSWIDTH=32>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("void registerResources(scc::tlm_target<BUSWIDTH>& target, uint64_t offset=0);");
    _builder.newLine();
    _builder.append("};");
    _builder.newLine();
    _builder.append("} // namespace gen");
    _builder.newLine();
    _builder.append("} // namespace ");
    _builder.append(namespace);
    _builder.newLineIfNotEmpty();
    _builder.append("//////////////////////////////////////////////////////////////////////////////");
    _builder.newLine();
    _builder.append("// member functions");
    _builder.newLine();
    _builder.append("//////////////////////////////////////////////////////////////////////////////");
    _builder.newLine();
    _builder.newLine();
    _builder.append("inline ");
    _builder.append(namespace);
    _builder.append("::gen::");
    String _effectiveName_11 = RdlUtil.effectiveName(this.componentDefinition);
    _builder.append(_effectiveName_11);
    _builder.append("_regs::");
    String _effectiveName_12 = RdlUtil.effectiveName(this.componentDefinition);
    _builder.append(_effectiveName_12);
    _builder.append("_regs(sc_core::sc_module_name nm)");
    _builder.newLineIfNotEmpty();
    _builder.append(": sc_core::sc_module(nm)");
    _builder.newLine();
    {
      EList<Instantiation> _instantiations_3 = this.componentDefinition.getInstantiations();
      for(final Instantiation instantiation_3 : _instantiations_3) {
        {
          EList<ComponentInstance> _componentInstances_2 = instantiation_3.getComponentInstances();
          for(final ComponentInstance instance_2 : _componentInstances_2) {
            {
              ComponentDefinitionType _type_6 = RdlUtil.getComponentDefinition(instantiation_3).getType();
              boolean _equals_9 = Objects.equal(_type_6, ComponentDefinitionType.REGFILE);
              if (_equals_9) {
                _builder.append("// , NAMED(");
                String _name_12 = instance_2.getName();
                _builder.append(_name_12);
                _builder.append(", i_");
                String _name_13 = instance_2.getName();
                _builder.append(_name_13);
                _builder.append(", 0, *this)");
                _builder.newLineIfNotEmpty();
              } else {
                ComponentDefinitionType _type_7 = RdlUtil.getComponentDefinition(instantiation_3).getType();
                boolean _equals_10 = Objects.equal(_type_7, ComponentDefinitionType.REG);
                if (_equals_10) {
                  _builder.append(", NAMED(");
                  String _name_14 = instance_2.getName();
                  _builder.append(_name_14);
                  _builder.append(", r_");
                  String _name_15 = instance_2.getName();
                  _builder.append(_name_15);
                  _builder.append(", 0, *this)");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
        }
      }
    }
    _builder.append("{");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("template<unsigned BUSWIDTH>");
    _builder.newLine();
    _builder.append("inline void ");
    _builder.append(namespace);
    _builder.append("::gen::");
    String _effectiveName_13 = RdlUtil.effectiveName(this.componentDefinition);
    _builder.append(_effectiveName_13);
    _builder.append("_regs::registerResources(scc::tlm_target<BUSWIDTH>& target, uint64_t offset) {");
    _builder.newLineIfNotEmpty();
    {
      EList<Instantiation> _instantiations_4 = this.componentDefinition.getInstantiations();
      for(final Instantiation instantiation_4 : _instantiations_4) {
        {
          EList<ComponentInstance> _componentInstances_3 = instantiation_4.getComponentInstances();
          for(final ComponentInstance instance_3 : _componentInstances_3) {
            {
              ComponentDefinitionType _type_8 = RdlUtil.getComponentDefinition(instantiation_4).getType();
              boolean _equals_11 = Objects.equal(_type_8, ComponentDefinitionType.REGFILE);
              if (_equals_11) {
                _builder.append("    ");
                _builder.append("i_");
                String _name_16 = instance_3.getName();
                _builder.append(_name_16, "    ");
                _builder.append(".registerResources(target, ");
                IntegerWithRadix _addressValue = RdlUtil.addressValue(instance_3);
                _builder.append(_addressValue, "    ");
                _builder.append("UL+offset);");
                _builder.newLineIfNotEmpty();
              } else {
                ComponentDefinitionType _type_9 = RdlUtil.getComponentDefinition(instantiation_4).getType();
                boolean _equals_12 = Objects.equal(_type_9, ComponentDefinitionType.REG);
                if (_equals_12) {
                  _builder.append("    ");
                  _builder.append("target.addResource(");
                  String _name_17 = instance_3.getName();
                  _builder.append(_name_17, "    ");
                  _builder.append(", ");
                  IntegerWithRadix _addressValue_1 = RdlUtil.addressValue(instance_3);
                  _builder.append(_addressValue_1, "    ");
                  _builder.append("UL);");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#endif // _");
    String _upperCase_4 = namespace.toUpperCase();
    _builder.append(_upperCase_4);
    _builder.append("_GEN_");
    String _upperCase_5 = RdlUtil.effectiveName(this.componentDefinition).toUpperCase();
    _builder.append(_upperCase_5);
    _builder.append("_H_");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  @Override
  public String generateSource(final String namespace) {
    return "";
  }
  
  public String genFieldDeclarations(final ComponentDefinition componentDef) {
    String _xblockexpression = null;
    {
      long i = 0L;
      String res = "";
      EList<Instantiation> _instantiations = componentDef.getInstantiations();
      for (final Instantiation inst : _instantiations) {
        EList<ComponentInstance> _componentInstances = inst.getComponentInstances();
        for (final ComponentInstance compInst : _componentInstances) {
          Object _size = compInst.getRange().getSize();
          boolean _tripleNotEquals = (_size != null);
          if (_tripleNotEquals) {
            String _res = res;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("BF_FIELD(");
            String _name = compInst.getName();
            _builder.append(_name);
            _builder.append(", ");
            _builder.append(i);
            _builder.append(", ");
            Object _size_1 = compInst.getRange().getSize();
            _builder.append(((IntegerWithRadix) _size_1).value);
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            res = (_res + _builder);
            long _i = i;
            Object _size_2 = compInst.getRange().getSize();
            i = (_i + ((IntegerWithRadix) _size_2).value);
          } else {
            Object _left = compInst.getRange().getLeft();
            final long start = ((IntegerWithRadix) _left).value;
            Object _right = compInst.getRange().getRight();
            final long end = ((IntegerWithRadix) _right).value;
            String _res_1 = res;
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("BF_FIELD(");
            String _name_1 = compInst.getName();
            _builder_1.append(_name_1);
            _builder_1.append(", ");
            _builder_1.append(end);
            _builder_1.append(", ");
            _builder_1.append(((start - end) + 1));
            _builder_1.append(");");
            _builder_1.newLineIfNotEmpty();
            res = (_res_1 + _builder_1);
            long _max = Math.max(start, end);
            long _plus = (_max + 1);
            i = _plus;
          }
        }
      }
      _xblockexpression = res;
    }
    return _xblockexpression;
  }
}
