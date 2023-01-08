package com.minres.rdl.generator

import com.minres.rdl.rdl.ComponentDefinition
import com.minres.rdl.rdl.ComponentDefinitionType
import java.util.Date

import static extension com.minres.rdl.RdlUtil.*

class FwAddrmapGenerator extends RdlBaseGenerator {
    
    val ComponentDefinition componentDefinition
    
    new(ComponentDefinition definition) {
        componentDefinition=definition
    }

	val nameMap = newLinkedHashSet()
		    
    override boolean getOverwrite(){
        true   
    }
    
    override generateHeader(String namespace) {'''
        /*
         * Copyright (c) 2023 MINRES Technologies GmbH
         *
         * SPDX-License-Identifier: Apache-2.0
         *
         * Created on: «new Date»
         *             *      «componentDefinition.effectiveName».h Author: <RDL Generator>
         *
         */
        
        #pragma once
        
        «FOR instantiation : componentDefinition.instantiationsOfType(ComponentDefinitionType.REGFILE)»
            «IF instantiation.component !== null && !nameMap.contains(instantiation.component.name)»
                #include "«instantiation.component.name».h"«nameMap.add(instantiation.component.name)?"":""»
            «ENDIF»
            «IF instantiation.componentRef !== null && !nameMap.contains(instantiation.componentRef.name)»
                #include "«instantiation.componentRef.name».h"«nameMap.add(instantiation.componentRef.name)?"":""»
            «ENDIF»
        «ENDFOR»
        
        
        «FOR instantiation : componentDefinition.instantiationsOfType(ComponentDefinitionType.REGFILE)»
            «FOR instance : instantiation.componentInstances»
                «IF instantiation.component !== null»
                    using «instance.name» = «instantiation.component.name»<«instance.addressValue»ULL>;
                «ENDIF»
                «IF instantiation.componentRef !== null»
                    using «instance.name» = «instantiation.componentRef.name»<«instance.addressValue»ULL>;
                «ENDIF»
            «ENDFOR»
        «ENDFOR»
        
        #endif /* _«componentDefinition.effectiveName.toUpperCase»_MAP_H_ */
    '''
    }
	    
    override generateSource(String namespace) {
        ''
    }
}