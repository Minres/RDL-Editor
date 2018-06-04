package com.minres.rdl.generator

import com.minres.rdl.generator.RdlBaseGenerator
import com.minres.rdl.rdl.ComponentDefinition
import com.minres.rdl.IntegerWithRadix
import com.minres.rdl.rdl.ComponentDefinitionType
import com.minres.rdl.rdl.ComponentInstance
import com.minres.rdl.rdl.Instantiation

import static extension com.minres.rdl.RdlUtil.*

class AddrmapGenerator extends RdlBaseGenerator {
    
    val ComponentDefinition componentDefinition
    
    new(ComponentDefinition definition) {
        componentDefinition=definition
    }
    
    override generateHeader() {'''
        #ifndef _«componentDefinition.effectiveName.toUpperCase»_MAP_H_
        #define _«componentDefinition.effectiveName.toUpperCase»_MAP_H_
        // need double braces, see https://stackoverflow.com/questions/6893700/how-to-construct-stdarray-object-with-initializer-list#6894191
        const std::array<sysc::target_memory_map_entry<32>, «componentDefinition.instanceCount(ComponentDefinitionType.REGFILE)»> «componentDefinition.effectiveName»_map = {{
            «FOR instantiation : componentDefinition.instantiationsOfType(ComponentDefinitionType.REGFILE)»
                «FOR instance : instantiation.componentInstances»
                    {&i_«instance.name», «instance.addressValue», 0x«Long.toHexString(instantiation.byteSize)»},
                «ENDFOR»
            «ENDFOR»
        }};
        
        #endif /* _«componentDefinition.effectiveName.toUpperCase»_MAP_H_ */
    '''
    }
	    
    override generateSource() {
        ''
    }
    

}