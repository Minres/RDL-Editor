package com.minres.rdl.generator

import com.minres.rdl.IntegerWithRadix
import com.minres.rdl.rdl.ComponentDefinition
import com.minres.rdl.rdl.ComponentDefinitionType
import com.minres.rdl.rdl.ComponentInstance
import com.minres.rdl.rdl.Instantiation
import java.util.Date
import com.minres.rdl.rdl.Range

import static extension com.minres.rdl.RdlUtil.*

class RegfileGenerator extends RdlBaseGenerator{
    
    val ComponentDefinition componentDefinition
    
    new(ComponentDefinition definition) {
        componentDefinition=definition
    }
    
    override String generateHeader()'''
        ////////////////////////////////////////////////////////////////////////////////
        // Copyright (C) 2017, MINRES Technologies GmbH
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
        
        #ifndef _«componentDefinition.name.toUpperCase»_H_
        #define _«componentDefinition.name.toUpperCase»_H_
        
        #include <sysc/utilities.h>
        #include <util/bit_field.h>
        #include <sysc/register.h>
        #include <sysc/tlm_target.h>
        
        namespace sysc {
        
        class «componentDefinition.name» :
                public sc_core::sc_module,
                public sysc::resetable
        {
        public:
            // storage declarations
            «FOR cdef : componentDefinition.componentDefinitions»
                «IF cdef.type == ComponentDefinitionType.REG»
                    BEGIN_BF_DECL(«cdef.effectiveName»+'_t'», uint«cdef»_t);
                    «cdef.genFieldDeclarations»
                    END_BF_DECL();
                «ENDIF»
            «ENDFOR»
            «FOR instantiation : componentDefinition.instantiations»
                «IF instantiation.componentRef !==null && instantiation.componentRef.type == ComponentDefinitionType.REG»
                    «instantiation.componentRef.effectiveName»+'_t' «instantiation.componentInstances.map[it.name].join(', ')»;
                «ENDIF»
                «IF instantiation.component !== null && instantiation.component.type == ComponentDefinitionType.REG»
                    «IF instantiation.isFilledByField»
                        «IF instantiation.componentInstances.filter[it.range===null].size>0»
                            uint«instantiation.size»_t «instantiation.componentInstances.filter[it.range===null].map['r_'+it.name].join(', ')»;
                        «ENDIF»
                        «FOR componentInstance : instantiation.componentInstances.filter[it.range!==null]»
                            std::array<uint«instantiation.size»_t, «componentInstance.range.absSize»> r_«componentInstance.name»;
                        «ENDFOR»
                    «ENDIF»
                    «IF !instantiation.isFilledByField»
                        BEGIN_BF_DECL(«instantiation.component.effectiveName»_t, uint«instantiation.size»_t);
                            «instantiation.definingComponent.genFieldDeclarations»
                        END_BF_DECL() «instantiation.componentInstances.filter[it.range===null].map['r_'+it.name].join(', ')»;
                        «FOR componentInstance : instantiation.componentInstances.filter[it.range!==null]»
                            std::array<«instantiation.component.effectiveName»_t, «componentInstance.range.absSize»> r_«componentInstance.name»;
                        «ENDFOR»
                    «ENDIF»
                    
                «ENDIF»
            «ENDFOR»
            // register declarations
            «FOR instantiation : componentDefinition.instantiations»
                «FOR instance : instantiation.componentInstances»
                    «IF instance.range===null»
                        «IF instantiation.isFilledByField»
                            sysc::sc_register<uint«instantiation.size»_t> «instance.name»;
                        «ENDIF»
                        «IF !instantiation.isFilledByField»
                            sysc::sc_register<«instantiation.component.effectiveName»_t> «instance.name»;
                        «ENDIF»
                    «ENDIF»
                    «IF instance.range!==null»
                        «IF instantiation.isFilledByField»
                            sysc::sc_register_indexed<uint«instantiation.size»_t, «instance.range.absSize»> «instance.name»;
                        «ENDIF»
                        «IF !instantiation.isFilledByField»
                            sysc::sc_register_indexed<«instantiation.component.effectiveName»_t, «instance.range.absSize»> «instance.name»;
                        «ENDIF»
                    «ENDIF»
                «ENDFOR»
            «ENDFOR»
            
            «componentDefinition.name»(sc_core::sc_module_name nm);
        
            template<unsigned BUSWIDTH=32>
            void registerResources(sysc::tlm_target<BUSWIDTH>& target);
        };
        }
        //////////////////////////////////////////////////////////////////////////////
        // member functions
        //////////////////////////////////////////////////////////////////////////////
        
        inline sysc::«componentDefinition.name»::«componentDefinition.name»(sc_core::sc_module_name nm)
        : sc_core::sc_module(nm)
        «FOR instantiation : componentDefinition.instantiations»
            «FOR instance : instantiation.componentInstances»
                , NAMED(«instance.name», r_«instance.name», 0, *this)
            «ENDFOR»
        «ENDFOR»
        {
        }
        
        template<unsigned BUSWIDTH>
        inline void sysc::«componentDefinition.name»::registerResources(sysc::tlm_target<BUSWIDTH>& target) {
            «FOR instantiation : componentDefinition.instantiations»
                «FOR instance : instantiation.componentInstances»
                    target.addResource(«instance.name», «instance.addressValue»UL);
                «ENDFOR»
            «ENDFOR»
        }
        
        #endif // _«componentDefinition.name.toUpperCase»_H_
        '''
    
    def long absSize(Range range){
        if(range.size!==null) 
            return (range.size as IntegerWithRadix).value 
        else
           return Math.abs((range.left as IntegerWithRadix).value - (range.right as IntegerWithRadix).value)+1 
    }
    
    def boolean isFilledByField(Instantiation instantiation){
        val fieldCount = instantiation.component.instanceCountOfType(ComponentDefinitionType.FIELD)
        if(fieldCount==1) {
            val instSize=instantiation.size
            val field = instantiation.component.instantiationsOfType(ComponentDefinitionType.FIELD).get(0)
            val inst = field.componentInstances.get(0)
            val range = inst.range
            if(range===null)
                return instSize==field.size
            if(range.size !== null)
                return instSize==(range.size as IntegerWithRadix).value
            else {
                val left=(range.left as IntegerWithRadix).value
                val right=(range.right as IntegerWithRadix).value
                val size = if(left>right) left-right+1 else right-left+1
                return instSize==size
            }
        }
        return false
    }
    
    def int instanceCountOfType(ComponentDefinition definition, ComponentDefinitionType type){
        definition.instantiationsOfType(type).map[it.componentInstances.size].reduce[p1, p2|p1+p1]
    }
    
    override generateSource() {
        ''
    }

    def String genFieldDeclarations(ComponentDefinition componentDef){
        var i=0L;
        var res = ""
        for( Instantiation inst: componentDef.instantiations){
            for(ComponentInstance compInst : inst.componentInstances){
                if(compInst.range.size!==null){
                    res+='''BF_FIELD(«compInst.name», «i», «(compInst.range.size as IntegerWithRadix).value»);
                    '''
                    i+=(compInst.range.size as IntegerWithRadix).value
                } else {
                    val start =(compInst.range.left as IntegerWithRadix).value
                    val end =  (compInst.range.right as IntegerWithRadix).value
                    res+='''BF_FIELD(«compInst.name», «end», «start-end+1»);
                    '''
                    i=Math.max(start, end)+1
                }
            }
        }
        res
    }
    

}