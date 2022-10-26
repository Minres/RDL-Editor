package com.minres.rdl.generator

import com.minres.rdl.rdl.ComponentDefinition
import com.minres.rdl.rdl.ComponentDefinitionType

import static extension com.minres.rdl.RdlUtil.*
import java.util.Date

class AddrmapGenerator extends RdlBaseGenerator {
    
    val ComponentDefinition componentDefinition
    
    new(ComponentDefinition definition) {
        componentDefinition=definition
    }
    
    override boolean getOverwrite(){
        true   
    }
    
    override generateHeader(String namespace) {'''
        /*
         * Copyright (c) 2019 -2022 MINRES Technologies GmbH
         *
         * SPDX-License-Identifier: Apache-2.0
         *
         * Created on: «new Date»
         *             *      «componentDefinition.effectiveName».h Author: <RDL Generator>
         *
         */

        #pragma once
        
        // need double braces, see https://stackoverflow.com/questions/6893700/how-to-construct-stdarray-object-with-initializer-list#6894191
        const std::array<scc::target_memory_map_entry<32>, «componentDefinition.instanceCount(ComponentDefinitionType.REGFILE)»> «componentDefinition.effectiveName»_map = {{
            «FOR instantiation : componentDefinition.instantiationsOfType(ComponentDefinitionType.REGFILE)»
                «FOR instance : instantiation.componentInstances»
                    {i_«instance.name».socket, «instance.addressValue», 0x«Long.toHexString(instantiation.byteSize)»},
                «ENDFOR»
            «ENDFOR»
        }};
        
        #endif /* _«componentDefinition.effectiveName.toUpperCase»_MAP_H_ */
    '''
    }
	    
    override generateSource(String namespace) {
        ''
    }
    

}