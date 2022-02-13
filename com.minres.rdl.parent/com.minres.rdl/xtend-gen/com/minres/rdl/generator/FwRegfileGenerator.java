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
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class FwRegfileGenerator extends RdlBaseGenerator {
  private final ComponentDefinition componentDefinition;
  
  public FwRegfileGenerator(final ComponentDefinition definition) {
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
    _builder.append("// Copyright (C) 2020-2022, MINRES Technologies GmbH");
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
    _builder.append("#include <util/bit_field.h>");
    _builder.newLine();
    _builder.append("#include <nonstd/span.hpp>");
    _builder.newLine();
    _builder.append("#include <cstdint>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("template<size_t BASE_ADDR>");
    _builder.newLine();
    _builder.append("struct ");
    String _name_1 = this.componentDefinition.getName();
    _builder.append(_name_1);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
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
            String _effectiveName = RdlUtil.effectiveName(cdef);
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
            String _effectiveName_1 = RdlUtil.effectiveName(instantiation.getComponentRef());
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
              boolean _isFilledByField = RdlUtil.isFilledByField(instantiation);
              boolean _not = (!_isFilledByField);
              if (_not) {
                _builder.append("    ");
                _builder.append("BEGIN_BF_DECL(");
                String _effectiveName_2 = RdlUtil.effectiveName(instantiation.getComponent());
                _builder.append(_effectiveName_2, "    ");
                _builder.append("_t, uint");
                long _size = RdlUtil.getSize(instantiation);
                _builder.append(_size, "    ");
                _builder.append("_t);");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append("    ");
                String _genFieldDeclarations_1 = this.genFieldDeclarations(RdlUtil.definingComponent(instantiation));
                _builder.append(_genFieldDeclarations_1, "        ");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append("END_BF_DECL() ");
                final Function1<ComponentInstance, Boolean> _function_1 = (ComponentInstance it) -> {
                  Range _range = it.getRange();
                  return Boolean.valueOf((_range == null));
                };
                final Function1<ComponentInstance, String> _function_2 = (ComponentInstance it) -> {
                  String _name_2 = it.getName();
                  return ("r_" + _name_2);
                };
                String _join_1 = IterableExtensions.join(IterableExtensions.<ComponentInstance, String>map(IterableExtensions.<ComponentInstance>filter(instantiation.getComponentInstances(), _function_1), _function_2), ", ");
                _builder.append(_join_1, "    ");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    _builder.append("    ");
    _builder.append("// register access");
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
                  boolean _isFilledByField_1 = RdlUtil.isFilledByField(instantiation_1);
                  if (_isFilledByField_1) {
                    _builder.append("    ");
                    _builder.append("static inline uint");
                    long _size_1 = RdlUtil.getSize(instantiation_1);
                    _builder.append(_size_1, "    ");
                    _builder.append("_t& ");
                    String _name_2 = instance.getName();
                    _builder.append(_name_2, "    ");
                    _builder.append("(){");
                    _builder.newLineIfNotEmpty();
                    _builder.append("    ");
                    _builder.append("    ");
                    _builder.append("return *reinterpret_cast<");
                    String _name_3 = instance.getName();
                    _builder.append(_name_3, "        ");
                    _builder.append("_t*>(BASE_ADDR+");
                    IntegerWithRadix _addressValue = RdlUtil.addressValue(instance);
                    _builder.append(_addressValue, "        ");
                    _builder.append("UL);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("    ");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
                {
                  boolean _isFilledByField_2 = RdlUtil.isFilledByField(instantiation_1);
                  boolean _not_1 = (!_isFilledByField_2);
                  if (_not_1) {
                    _builder.append("    ");
                    _builder.append("static inline ");
                    String _name_4 = instance.getName();
                    _builder.append(_name_4, "    ");
                    _builder.append("_t& ");
                    String _name_5 = instance.getName();
                    _builder.append(_name_5, "    ");
                    _builder.append("(){");
                    _builder.newLineIfNotEmpty();
                    _builder.append("    ");
                    _builder.append("    ");
                    _builder.append("return *reinterpret_cast<");
                    String _name_6 = instance.getName();
                    _builder.append(_name_6, "        ");
                    _builder.append("_t*>(BASE_ADDR+");
                    IntegerWithRadix _addressValue_1 = RdlUtil.addressValue(instance);
                    _builder.append(_addressValue_1, "        ");
                    _builder.append("UL);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("    ");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              }
            }
            {
              Range _range_1 = instance.getRange();
              boolean _tripleNotEquals = (_range_1 != null);
              if (_tripleNotEquals) {
                {
                  boolean _isFilledByField_3 = RdlUtil.isFilledByField(instantiation_1);
                  if (_isFilledByField_3) {
                    _builder.append("    ");
                    _builder.append("static inline nonstd::span<uint");
                    long _size_2 = RdlUtil.getSize(instantiation_1);
                    _builder.append(_size_2, "    ");
                    _builder.append("_t, ");
                    long _absSize = RdlUtil.absSize(instance.getRange());
                    _builder.append(_absSize, "    ");
                    _builder.append(">& ");
                    String _name_7 = instance.getName();
                    _builder.append(_name_7, "    ");
                    _builder.append("(){");
                    _builder.newLineIfNotEmpty();
                    _builder.append("    ");
                    _builder.append("    ");
                    _builder.append("return *reinterpret_cast<nonstd::span<uint");
                    long _size_3 = RdlUtil.getSize(instantiation_1);
                    _builder.append(_size_3, "        ");
                    _builder.append("_t, ");
                    long _absSize_1 = RdlUtil.absSize(instance.getRange());
                    _builder.append(_absSize_1, "        ");
                    _builder.append(">*>(BASE_ADDR+");
                    IntegerWithRadix _addressValue_2 = RdlUtil.addressValue(instance);
                    _builder.append(_addressValue_2, "        ");
                    _builder.append("UL);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("    ");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
                {
                  boolean _isFilledByField_4 = RdlUtil.isFilledByField(instantiation_1);
                  boolean _not_2 = (!_isFilledByField_4);
                  if (_not_2) {
                    _builder.append("    ");
                    _builder.append("static inline nonstd::span<");
                    String _name_8 = instance.getName();
                    _builder.append(_name_8, "    ");
                    _builder.append("_t, ");
                    long _absSize_2 = RdlUtil.absSize(instance.getRange());
                    _builder.append(_absSize_2, "    ");
                    _builder.append(">& ");
                    String _name_9 = instance.getName();
                    _builder.append(_name_9, "    ");
                    _builder.append("(){");
                    _builder.newLineIfNotEmpty();
                    _builder.append("    ");
                    _builder.append("    ");
                    _builder.append("return *reinterpret_cast<nonstd::span<");
                    String _name_10 = instance.getName();
                    _builder.append(_name_10, "        ");
                    _builder.append("_t, ");
                    long _absSize_3 = RdlUtil.absSize(instance.getRange());
                    _builder.append(_absSize_3, "        ");
                    _builder.append(">*>(BASE_ADDR+");
                    IntegerWithRadix _addressValue_3 = RdlUtil.addressValue(instance);
                    _builder.append(_addressValue_3, "        ");
                    _builder.append("UL);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("    ");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              }
            }
          }
        }
      }
    }
    _builder.append("};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#endif // _");
    String _upperCase_2 = this.componentDefinition.getName().toUpperCase();
    _builder.append(_upperCase_2);
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
