package com.minres.rdl.generator

import com.minres.rdl.generator.RdlBaseGenerator
import com.minres.rdl.rdl.ComponentDefinition
import com.minres.rdl.IntegerWithRadix
import com.minres.rdl.rdl.ComponentDefinitionType

class AddrmapGenerator extends RdlBaseGenerator {
    
    val ComponentDefinition componentDefinition
    
    new(ComponentDefinition definition) {
        componentDefinition=definition
    }
    
    override generateHeader() {'''
        #ifndef _E300_PLAT_MAP_H_
        #define _E300_PLAT_MAP_H_
        // need double braces, see https://stackoverflow.com/questions/6893700/how-to-construct-stdarray-object-with-initializer-list#6894191
        const std::array<sysc::target_memory_map_entry<32>, «componentDefinition.instanceCount(ComponentDefinitionType.REGFILE)»> e300_plat_map = {{
            «FOR instantiation : componentDefinition.instantiationsOfType(ComponentDefinitionType.REGFILE)»
                «FOR instance : instantiation.componentInstances»
                    {&i_«instance.name», 0x«Long.toHexString((instance.address as IntegerWithRadix).value)», 0x«Long.toHexString(instantiation.byteSize)»},
                «ENDFOR»
            «ENDFOR»
        }};
        
        #endif /* _E300_PLAT_MAP_H_ */
    '''
    }
    
    override generateSource() {
        ''
    }
    

}