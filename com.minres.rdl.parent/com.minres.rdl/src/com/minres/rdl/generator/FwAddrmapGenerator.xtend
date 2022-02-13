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
        ////////////////////////////////////////////////////////////////////////////////
        // Copyright (C) 2020-2022, MINRES Technologies GmbH
        // All rights reserved.
        //
        // Redistribution and use in source and binary forms, with or without
        // modification, are permitted provided that the following conditions are met:
        //
        // 1. Redistributions of source code must retain the above copyright notice,
        //    this list of conditions and the following disclaimer.
        //
        // 2. Redistributions in binary form must reproduce the above copyright notice,
        //    this list of conditions and the following disclaimer in the documentation
        //    and/or other materials provided with the distribution.
        //
        // 3. Neither the name of the copyright holder nor the names of its contributors
        //    may be used to endorse or promote products derived from this software
        //    without specific prior written permission.
        //
        // THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
        // AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
        // IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
        // ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
        // LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
        // CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
        // SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
        // INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
        // CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
        // ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
        // POSSIBILITY OF SUCH DAMAGE.
        //
        // Created on: «new Date»
        //             *      «componentDefinition.name».h Author: <RDL Generator>
        //
        ////////////////////////////////////////////////////////////////////////////////
        
        #ifndef _«componentDefinition.effectiveName.toUpperCase»_MAP_H_
        #define _«componentDefinition.effectiveName.toUpperCase»_MAP_H_
        
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