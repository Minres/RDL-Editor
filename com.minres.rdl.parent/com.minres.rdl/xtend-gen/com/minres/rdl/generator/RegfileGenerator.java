package com.minres.rdl.generator;

import com.google.common.base.Objects;
import com.minres.rdl.IntegerWithRadix;
import com.minres.rdl.generator.RdlBaseGenerator;
import com.minres.rdl.rdl.ComponentDefinition;
import com.minres.rdl.rdl.ComponentDefinitionType;
import com.minres.rdl.rdl.ComponentInstance;
import com.minres.rdl.rdl.Instantiation;
import com.minres.rdl.rdl.Range;
import java.util.Date;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class RegfileGenerator extends RdlBaseGenerator {
  private final ComponentDefinition componentDefinition;
  
  public RegfileGenerator(final ComponentDefinition definition) {
    this.componentDefinition = definition;
  }
  
  @Override
  public String generateHeader() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("////////////////////////////////////////////////////////////////////////////////");
    _builder.newLine();
    _builder.append("// Copyright (C) 2017, MINRES Technologies GmbH");
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
    String _name = this.componentDefinition.getName();
    _builder.append(_name);
    _builder.append(".h Author: <RDL Generator>");
    _builder.newLineIfNotEmpty();
    _builder.append("//");
    _builder.newLine();
    _builder.append("////////////////////////////////////////////////////////////////////////////////");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#ifndef _");
    String _upperCase = this.componentDefinition.getName().toUpperCase();
    _builder.append(_upperCase);
    _builder.append("_H_");
    _builder.newLineIfNotEmpty();
    _builder.append("#define _");
    String _upperCase_1 = this.componentDefinition.getName().toUpperCase();
    _builder.append(_upperCase_1);
    _builder.append("_H_");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include <sysc/utilities.h>");
    _builder.newLine();
    _builder.append("#include <util/bit_field.h>");
    _builder.newLine();
    _builder.append("#include <sysc/register.h>");
    _builder.newLine();
    _builder.append("#include <sysc/tlm_target.h>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("namespace sysc {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    String _name_1 = this.componentDefinition.getName();
    _builder.append(_name_1);
    _builder.append(" :");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("public sc_core::sc_module,");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("public sysc::resetable");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("public:");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// storage declarations");
    _builder.newLine();
    {
      EList<ComponentDefinition> _componentDefinitions = this.componentDefinition.getComponentDefinitions();
      for(final ComponentDefinition cdef : _componentDefinitions) {
        {
          ComponentDefinitionType _type = cdef.getType();
          boolean _equals = Objects.equal(_type, ComponentDefinitionType.REG);
          if (_equals) {
            _builder.append("    ");
            _builder.append("BEGIN_BF_DECL(");
            String _effectiveName = this.effectiveName(cdef);
            _builder.append(_effectiveName, "    ");
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
      EList<Instantiation> _instantiations = this.componentDefinition.getInstantiations();
      for(final Instantiation instantiation : _instantiations) {
        {
          if (((instantiation.getComponentRef() != null) && Objects.equal(instantiation.getComponentRef().getType(), ComponentDefinitionType.REG))) {
            _builder.append("    ");
            String _effectiveName_1 = this.effectiveName(instantiation.getComponentRef());
            _builder.append(_effectiveName_1, "    ");
            _builder.append("+\'_t\' ");
            final Function1<ComponentInstance, String> _function = (ComponentInstance it) -> {
              return it.getName();
            };
            String _join = IterableExtensions.join(ListExtensions.<ComponentInstance, String>map(instantiation.getComponentInstances(), _function), ", ");
            _builder.append(_join, "    ");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if (((instantiation.getComponent() != null) && Objects.equal(instantiation.getComponent().getType(), ComponentDefinitionType.REG))) {
            {
              boolean _isFilledByField = this.isFilledByField(instantiation);
              if (_isFilledByField) {
                {
                  final Function1<ComponentInstance, Boolean> _function_1 = (ComponentInstance it) -> {
                    Range _range = it.getRange();
                    return Boolean.valueOf((_range == null));
                  };
                  int _size = IterableExtensions.size(IterableExtensions.<ComponentInstance>filter(instantiation.getComponentInstances(), _function_1));
                  boolean _greaterThan = (_size > 0);
                  if (_greaterThan) {
                    _builder.append("    ");
                    _builder.append("uint");
                    long _size_1 = this.getSize(instantiation);
                    _builder.append(_size_1, "    ");
                    _builder.append("_t ");
                    final Function1<ComponentInstance, Boolean> _function_2 = (ComponentInstance it) -> {
                      Range _range = it.getRange();
                      return Boolean.valueOf((_range == null));
                    };
                    final Function1<ComponentInstance, String> _function_3 = (ComponentInstance it) -> {
                      String _name_2 = it.getName();
                      return ("r_" + _name_2);
                    };
                    String _join_1 = IterableExtensions.join(IterableExtensions.<ComponentInstance, String>map(IterableExtensions.<ComponentInstance>filter(instantiation.getComponentInstances(), _function_2), _function_3), ", ");
                    _builder.append(_join_1, "    ");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  final Function1<ComponentInstance, Boolean> _function_4 = (ComponentInstance it) -> {
                    Range _range = it.getRange();
                    return Boolean.valueOf((_range != null));
                  };
                  Iterable<ComponentInstance> _filter = IterableExtensions.<ComponentInstance>filter(instantiation.getComponentInstances(), _function_4);
                  for(final ComponentInstance componentInstance : _filter) {
                    _builder.append("    ");
                    _builder.append("std::array<uint");
                    long _size_2 = this.getSize(instantiation);
                    _builder.append(_size_2, "    ");
                    _builder.append("_t, ");
                    long _absSize = this.absSize(componentInstance.getRange());
                    _builder.append(_absSize, "    ");
                    _builder.append("> r_");
                    String _name_2 = componentInstance.getName();
                    _builder.append(_name_2, "    ");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            {
              boolean _isFilledByField_1 = this.isFilledByField(instantiation);
              boolean _not = (!_isFilledByField_1);
              if (_not) {
                _builder.append("    ");
                _builder.append("BEGIN_BF_DECL(");
                String _effectiveName_2 = this.effectiveName(instantiation.getComponent());
                _builder.append(_effectiveName_2, "    ");
                _builder.append("_t, uint");
                long _size_3 = this.getSize(instantiation);
                _builder.append(_size_3, "    ");
                _builder.append("_t);");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append("    ");
                String _genFieldDeclarations_1 = this.genFieldDeclarations(this.definingComponent(instantiation));
                _builder.append(_genFieldDeclarations_1, "        ");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append("END_BF_DECL() ");
                final Function1<ComponentInstance, Boolean> _function_5 = (ComponentInstance it) -> {
                  Range _range = it.getRange();
                  return Boolean.valueOf((_range == null));
                };
                final Function1<ComponentInstance, String> _function_6 = (ComponentInstance it) -> {
                  String _name_3 = it.getName();
                  return ("r_" + _name_3);
                };
                String _join_2 = IterableExtensions.join(IterableExtensions.<ComponentInstance, String>map(IterableExtensions.<ComponentInstance>filter(instantiation.getComponentInstances(), _function_5), _function_6), ", ");
                _builder.append(_join_2, "    ");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                {
                  final Function1<ComponentInstance, Boolean> _function_7 = (ComponentInstance it) -> {
                    Range _range = it.getRange();
                    return Boolean.valueOf((_range != null));
                  };
                  Iterable<ComponentInstance> _filter_1 = IterableExtensions.<ComponentInstance>filter(instantiation.getComponentInstances(), _function_7);
                  for(final ComponentInstance componentInstance_1 : _filter_1) {
                    _builder.append("    ");
                    _builder.append("std::array<");
                    String _effectiveName_3 = this.effectiveName(instantiation.getComponent());
                    _builder.append(_effectiveName_3, "    ");
                    _builder.append("_t, ");
                    long _absSize_1 = this.absSize(componentInstance_1.getRange());
                    _builder.append(_absSize_1, "    ");
                    _builder.append("> r_");
                    String _name_3 = componentInstance_1.getName();
                    _builder.append(_name_3, "    ");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            _builder.append("    ");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("    ");
    _builder.append("// register declarations");
    _builder.newLine();
    {
      EList<Instantiation> _instantiations_1 = this.componentDefinition.getInstantiations();
      for(final Instantiation instantiation_1 : _instantiations_1) {
        {
          EList<ComponentInstance> _componentInstances = instantiation_1.getComponentInstances();
          for(final ComponentInstance instance : _componentInstances) {
            {
              Range _range = instance.getRange();
              boolean _tripleEquals = (_range == null);
              if (_tripleEquals) {
                {
                  boolean _isFilledByField_2 = this.isFilledByField(instantiation_1);
                  if (_isFilledByField_2) {
                    _builder.append("    ");
                    _builder.append("sysc::sc_register<uint");
                    long _size_4 = this.getSize(instantiation_1);
                    _builder.append(_size_4, "    ");
                    _builder.append("_t> ");
                    String _name_4 = instance.getName();
                    _builder.append(_name_4, "    ");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isFilledByField_3 = this.isFilledByField(instantiation_1);
                  boolean _not_1 = (!_isFilledByField_3);
                  if (_not_1) {
                    _builder.append("    ");
                    _builder.append("sysc::sc_register<");
                    String _effectiveName_4 = this.effectiveName(instantiation_1.getComponent());
                    _builder.append(_effectiveName_4, "    ");
                    _builder.append("_t> ");
                    String _name_5 = instance.getName();
                    _builder.append(_name_5, "    ");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            {
              Range _range_1 = instance.getRange();
              boolean _tripleNotEquals = (_range_1 != null);
              if (_tripleNotEquals) {
                {
                  boolean _isFilledByField_4 = this.isFilledByField(instantiation_1);
                  if (_isFilledByField_4) {
                    _builder.append("    ");
                    _builder.append("sysc::sc_register_indexed<uint");
                    long _size_5 = this.getSize(instantiation_1);
                    _builder.append(_size_5, "    ");
                    _builder.append("_t, ");
                    long _absSize_2 = this.absSize(instance.getRange());
                    _builder.append(_absSize_2, "    ");
                    _builder.append("> ");
                    String _name_6 = instance.getName();
                    _builder.append(_name_6, "    ");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  boolean _isFilledByField_5 = this.isFilledByField(instantiation_1);
                  boolean _not_2 = (!_isFilledByField_5);
                  if (_not_2) {
                    _builder.append("    ");
                    _builder.append("sysc::sc_register_indexed<");
                    String _effectiveName_5 = this.effectiveName(instantiation_1.getComponent());
                    _builder.append(_effectiveName_5, "    ");
                    _builder.append("_t, ");
                    long _absSize_3 = this.absSize(instance.getRange());
                    _builder.append(_absSize_3, "    ");
                    _builder.append("> ");
                    String _name_7 = instance.getName();
                    _builder.append(_name_7, "    ");
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
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    String _name_8 = this.componentDefinition.getName();
    _builder.append(_name_8, "    ");
    _builder.append("(sc_core::sc_module_name nm);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("template<unsigned BUSWIDTH=32>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("void registerResources(sysc::tlm_target<BUSWIDTH>& target);");
    _builder.newLine();
    _builder.append("};");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("//////////////////////////////////////////////////////////////////////////////");
    _builder.newLine();
    _builder.append("// member functions");
    _builder.newLine();
    _builder.append("//////////////////////////////////////////////////////////////////////////////");
    _builder.newLine();
    _builder.newLine();
    _builder.append("inline sysc::");
    String _name_9 = this.componentDefinition.getName();
    _builder.append(_name_9);
    _builder.append("::");
    String _name_10 = this.componentDefinition.getName();
    _builder.append(_name_10);
    _builder.append("(sc_core::sc_module_name nm)");
    _builder.newLineIfNotEmpty();
    _builder.append(": sc_core::sc_module(nm)");
    _builder.newLine();
    {
      EList<Instantiation> _instantiations_2 = this.componentDefinition.getInstantiations();
      for(final Instantiation instantiation_2 : _instantiations_2) {
        {
          EList<ComponentInstance> _componentInstances_1 = instantiation_2.getComponentInstances();
          for(final ComponentInstance instance_1 : _componentInstances_1) {
            _builder.append(", NAMED(");
            String _name_11 = instance_1.getName();
            _builder.append(_name_11);
            _builder.append(", r_");
            String _name_12 = instance_1.getName();
            _builder.append(_name_12);
            _builder.append(", 0, *this)");
            _builder.newLineIfNotEmpty();
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
    _builder.append("inline void sysc::");
    String _name_13 = this.componentDefinition.getName();
    _builder.append(_name_13);
    _builder.append("::registerResources(sysc::tlm_target<BUSWIDTH>& target) {");
    _builder.newLineIfNotEmpty();
    {
      EList<Instantiation> _instantiations_3 = this.componentDefinition.getInstantiations();
      for(final Instantiation instantiation_3 : _instantiations_3) {
        {
          EList<ComponentInstance> _componentInstances_2 = instantiation_3.getComponentInstances();
          for(final ComponentInstance instance_2 : _componentInstances_2) {
            _builder.append("    ");
            _builder.append("target.addResource(");
            String _name_14 = instance_2.getName();
            _builder.append(_name_14, "    ");
            _builder.append(", 0x");
            Object _address = instance_2.getAddress();
            String _hexString = Long.toHexString(((IntegerWithRadix) _address).value);
            _builder.append(_hexString, "    ");
            _builder.append("UL);");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#endif // _");
    String _upperCase_2 = this.componentDefinition.getName().toUpperCase();
    _builder.append(_upperCase_2);
    _builder.append("_H_");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public long absSize(final Range range) {
    Object _size = range.getSize();
    boolean _tripleNotEquals = (_size != null);
    if (_tripleNotEquals) {
      Object _size_1 = range.getSize();
      return ((IntegerWithRadix) _size_1).value;
    } else {
      Object _left = range.getLeft();
      Object _right = range.getRight();
      long _abs = Math.abs((((IntegerWithRadix) _left).value - ((IntegerWithRadix) _right).value));
      return (_abs + 1);
    }
  }
  
  public boolean isFilledByField(final Instantiation instantiation) {
    final int fieldCount = this.instanceCountOfType(instantiation.getComponent(), ComponentDefinitionType.FIELD);
    if ((fieldCount == 1)) {
      final long instSize = this.getSize(instantiation);
      final Instantiation field = ((Instantiation[])Conversions.unwrapArray(this.instantiationsOfType(instantiation.getComponent(), ComponentDefinitionType.FIELD), Instantiation.class))[0];
      final ComponentInstance inst = field.getComponentInstances().get(0);
      final Range range = inst.getRange();
      if ((range == null)) {
        long _size = this.getSize(field);
        return (instSize == _size);
      }
      Object _size_1 = range.getSize();
      boolean _tripleNotEquals = (_size_1 != null);
      if (_tripleNotEquals) {
        Object _size_2 = range.getSize();
        return (instSize == ((IntegerWithRadix) _size_2).value);
      } else {
        Object _left = range.getLeft();
        final long left = ((IntegerWithRadix) _left).value;
        Object _right = range.getRight();
        final long right = ((IntegerWithRadix) _right).value;
        long _xifexpression = (long) 0;
        if ((left > right)) {
          _xifexpression = ((left - right) + 1);
        } else {
          _xifexpression = ((right - left) + 1);
        }
        final long size = _xifexpression;
        return (instSize == size);
      }
    }
    return false;
  }
  
  public int instanceCountOfType(final ComponentDefinition definition, final ComponentDefinitionType type) {
    final Function1<Instantiation, Integer> _function = (Instantiation it) -> {
      return Integer.valueOf(it.getComponentInstances().size());
    };
    final Function2<Integer, Integer, Integer> _function_1 = (Integer p1, Integer p2) -> {
      return Integer.valueOf(((p1).intValue() + (p1).intValue()));
    };
    return (int) IterableExtensions.<Integer>reduce(IterableExtensions.<Instantiation, Integer>map(this.instantiationsOfType(definition, type), _function), _function_1);
  }
  
  public Iterable<Instantiation> instantiationsOfType(final ComponentDefinition definition, final ComponentDefinitionType type) {
    final Function1<Instantiation, Boolean> _function = (Instantiation it) -> {
      ComponentDefinitionType _type = this.definingComponent(it).getType();
      return Boolean.valueOf(Objects.equal(_type, type));
    };
    return IterableExtensions.<Instantiation>filter(definition.getInstantiations(), _function);
  }
  
  @Override
  public String generateSource() {
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
