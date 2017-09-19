package com.minres.rdl.generator;

import com.minres.rdl.generator.RdlBaseGenerator;
import com.minres.rdl.rdl.ComponentDefinition;
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
    _builder.append("const std::array<sysc::target_memory_map_entry<32>, 3> e300_plat_map = {{");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("{&i_gpio, 0x10012000, 0x1000},");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("{&i_uart, 0x10013000, 0x1000},");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("{&i_spi,  0x10014000, 0x1000}");
    _builder.newLine();
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
