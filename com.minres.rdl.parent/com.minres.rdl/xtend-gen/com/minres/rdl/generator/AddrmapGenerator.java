package com.minres.rdl.generator;

import com.minres.rdl.IntegerWithRadix;
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
    _builder.append("#ifndef _E300_PLAT_MAP_H_");
    _builder.newLine();
    _builder.append("#define _E300_PLAT_MAP_H_");
    _builder.newLine();
    _builder.append("// need double braces, see https://stackoverflow.com/questions/6893700/how-to-construct-stdarray-object-with-initializer-list#6894191");
    _builder.newLine();
    _builder.append("const std::array<sysc::target_memory_map_entry<32>, ");
    int _instanceCount = this.instanceCount(this.componentDefinition, ComponentDefinitionType.REGFILE);
    _builder.append(_instanceCount);
    _builder.append("> e300_plat_map = {{");
    _builder.newLineIfNotEmpty();
    {
      Iterable<Instantiation> _instantiationsOfType = this.instantiationsOfType(this.componentDefinition, ComponentDefinitionType.REGFILE);
      for(final Instantiation instantiation : _instantiationsOfType) {
        {
          EList<ComponentInstance> _componentInstances = instantiation.getComponentInstances();
          for(final ComponentInstance instance : _componentInstances) {
            _builder.append("    ");
            _builder.append("{&i_");
            String _name = instance.getName();
            _builder.append(_name, "    ");
            _builder.append(", 0x");
            Object _address = instance.getAddress();
            String _hexString = Long.toHexString(((IntegerWithRadix) _address).value);
            _builder.append(_hexString, "    ");
            _builder.append(", 0x");
            String _hexString_1 = Long.toHexString(this.byteSize(instantiation));
            _builder.append(_hexString_1, "    ");
            _builder.append("},");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("}};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#endif /* _E300_PLAT_MAP_H_ */");
    _builder.newLine();
    return _builder.toString();
  }
  
  @Override
  public String generateSource() {
    return "";
  }
}
