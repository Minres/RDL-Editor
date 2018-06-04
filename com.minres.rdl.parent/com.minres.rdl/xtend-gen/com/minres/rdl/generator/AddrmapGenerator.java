package com.minres.rdl.generator;

import com.minres.rdl.IntegerWithRadix;
import com.minres.rdl.RdlUtil;
import com.minres.rdl.generator.RdlBaseGenerator;
import com.minres.rdl.rdl.ComponentDefinition;
import com.minres.rdl.rdl.ComponentDefinitionType;
import com.minres.rdl.rdl.ComponentInstance;
import com.minres.rdl.rdl.Instantiation;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class AddrmapGenerator extends RdlBaseGenerator {
  private final ComponentDefinition componentDefinition;
  
  public AddrmapGenerator(final ComponentDefinition definition) {
    this.componentDefinition = definition;
  }
  
  @Override
  public String generateHeader() {
    StringConcatenation _builder = new StringConcatenation();
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
    _builder.append("// need double braces, see https://stackoverflow.com/questions/6893700/how-to-construct-stdarray-object-with-initializer-list#6894191");
    _builder.newLine();
    _builder.append("const std::array<sysc::target_memory_map_entry<32>, ");
    int _instanceCount = RdlUtil.instanceCount(this.componentDefinition, ComponentDefinitionType.REGFILE);
    _builder.append(_instanceCount);
    _builder.append("> ");
    String _effectiveName = RdlUtil.effectiveName(this.componentDefinition);
    _builder.append(_effectiveName);
    _builder.append("_map = {{");
    _builder.newLineIfNotEmpty();
    {
      Iterable<Instantiation> _instantiationsOfType = RdlUtil.instantiationsOfType(this.componentDefinition, ComponentDefinitionType.REGFILE);
      for(final Instantiation instantiation : _instantiationsOfType) {
        {
          EList<ComponentInstance> _componentInstances = instantiation.getComponentInstances();
          for(final ComponentInstance instance : _componentInstances) {
            _builder.append("    ");
            _builder.append("{&i_");
            String _name = instance.getName();
            _builder.append(_name, "    ");
            _builder.append(", ");
            IntegerWithRadix _addressValue = RdlUtil.addressValue(instance);
            _builder.append(_addressValue, "    ");
            _builder.append(", 0x");
            String _hexString = Long.toHexString(RdlUtil.byteSize(instantiation));
            _builder.append(_hexString, "    ");
            _builder.append("},");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("}};");
    _builder.newLine();
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
