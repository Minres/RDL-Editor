package com.minres.rdl.generator;

import com.minres.rdl.IntegerWithRadix;
import com.minres.rdl.RdlUtil;
import com.minres.rdl.generator.RdlBaseGenerator;
import com.minres.rdl.rdl.ComponentDefinition;
import com.minres.rdl.rdl.ComponentDefinitionType;
import com.minres.rdl.rdl.ComponentInstance;
import com.minres.rdl.rdl.Instantiation;
import java.util.Date;
import java.util.LinkedHashSet;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class FwAddrmapGenerator extends RdlBaseGenerator {
  private final ComponentDefinition componentDefinition;
  
  public FwAddrmapGenerator(final ComponentDefinition definition) {
    this.componentDefinition = definition;
  }
  
  private final LinkedHashSet<Object> nameMap = CollectionLiterals.<Object>newLinkedHashSet();
  
  @Override
  public String generateHeader() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("////////////////////////////////////////////////////////////////////////////////");
    _builder.newLine();
    _builder.append("// Copyright (C) 2020, MINRES Technologies GmbH");
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
    String _upperCase = RdlUtil.effectiveName(this.componentDefinition).toUpperCase();
    _builder.append(_upperCase);
    _builder.append("_MAP_H_");
    _builder.newLineIfNotEmpty();
    _builder.append("#define _");
    String _upperCase_1 = RdlUtil.effectiveName(this.componentDefinition).toUpperCase();
    _builder.append(_upperCase_1);
    _builder.append("_MAP_H_");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      Iterable<Instantiation> _instantiationsOfType = RdlUtil.instantiationsOfType(this.componentDefinition, ComponentDefinitionType.REGFILE);
      for(final Instantiation instantiation : _instantiationsOfType) {
        {
          if (((instantiation.getComponent() != null) && (!this.nameMap.contains(instantiation.getComponent().getName())))) {
            _builder.append("#include \"");
            String _name_1 = instantiation.getComponent().getName();
            _builder.append(_name_1);
            _builder.append(".h\"");
            boolean _add = this.nameMap.add(instantiation.getComponent().getName());
            _builder.append(_add);
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if (((instantiation.getComponentRef() != null) && (!this.nameMap.contains(instantiation.getComponentRef().getName())))) {
            _builder.append("#include \"");
            String _name_2 = instantiation.getComponentRef().getName();
            _builder.append(_name_2);
            _builder.append(".h\"");
            boolean _add_1 = this.nameMap.add(instantiation.getComponentRef().getName());
            _builder.append(_add_1);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    _builder.newLine();
    {
      Iterable<Instantiation> _instantiationsOfType_1 = RdlUtil.instantiationsOfType(this.componentDefinition, ComponentDefinitionType.REGFILE);
      for(final Instantiation instantiation_1 : _instantiationsOfType_1) {
        {
          EList<ComponentInstance> _componentInstances = instantiation_1.getComponentInstances();
          for(final ComponentInstance instance : _componentInstances) {
            {
              ComponentDefinition _component = instantiation_1.getComponent();
              boolean _tripleNotEquals = (_component != null);
              if (_tripleNotEquals) {
                _builder.append("using ");
                String _name_3 = instance.getName();
                _builder.append(_name_3);
                _builder.append(" = ");
                String _name_4 = instantiation_1.getComponent().getName();
                _builder.append(_name_4);
                _builder.append("<");
                IntegerWithRadix _addressValue = RdlUtil.addressValue(instance);
                _builder.append(_addressValue);
                _builder.append("ULL>;");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              ComponentDefinition _componentRef = instantiation_1.getComponentRef();
              boolean _tripleNotEquals_1 = (_componentRef != null);
              if (_tripleNotEquals_1) {
                _builder.append("using ");
                String _name_5 = instance.getName();
                _builder.append(_name_5);
                _builder.append(" = ");
                String _name_6 = instantiation_1.getComponentRef().getName();
                _builder.append(_name_6);
                _builder.append("<");
                IntegerWithRadix _addressValue_1 = RdlUtil.addressValue(instance);
                _builder.append(_addressValue_1);
                _builder.append("ULL>;");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("#endif /* _");
    String _upperCase_2 = RdlUtil.effectiveName(this.componentDefinition).toUpperCase();
    _builder.append(_upperCase_2);
    _builder.append("_MAP_H_ */");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  @Override
  public String generateSource() {
    return "";
  }
}
