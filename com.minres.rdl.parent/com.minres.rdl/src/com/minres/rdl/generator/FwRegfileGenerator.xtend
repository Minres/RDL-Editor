package com.minres.rdl.generator

import com.minres.rdl.IntegerWithRadix
import com.minres.rdl.rdl.ComponentDefinition
import com.minres.rdl.rdl.ComponentDefinitionType
import com.minres.rdl.rdl.ComponentInstance
import com.minres.rdl.rdl.Instantiation
import java.util.Date

import static extension com.minres.rdl.RdlUtil.*

class FwRegfileGenerator extends RdlBaseGenerator{
    
    val ComponentDefinition componentDefinition
    
    new(ComponentDefinition definition) {
        componentDefinition=definition
    }
    
    override boolean getOverwrite(){
        true   
    }
    
    override String generateHeader(String namespace)'''
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
        
        #ifndef _«componentDefinition.name.toUpperCase»_H_
        #define _«componentDefinition.name.toUpperCase»_H_
        
        #include <util/bit_field.h>
        #include <nonstd/span.hpp>
        #include <cstdint>
        
        template<size_t BASE_ADDR>
        struct «componentDefinition.name» {

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
                    «IF !instantiation.isFilledByField»
                        BEGIN_BF_DECL(«instantiation.component.effectiveName»_t, uint«instantiation.size»_t);
                            «instantiation.definingComponent.genFieldDeclarations»
                        END_BF_DECL() «instantiation.componentInstances.filter[it.range===null].map['r_'+it.name].join(', ')»;

                    «ENDIF»
                «ENDIF»
            «ENDFOR»
            // register access
            «FOR instantiation : componentDefinition.instantiations»
                «FOR instance : instantiation.componentInstances»
                    «IF instance.range===null»
                        «IF instantiation.isFilledByField»
                            static inline uint«instantiation.size»_t& «instance.name»(){
                                return *reinterpret_cast<«instance.name»_t*>(BASE_ADDR+«instance.addressValue»UL);
                            }
                        «ENDIF»
                        «IF !instantiation.isFilledByField»
                            static inline «instance.name»_t& «instance.name»(){
                                return *reinterpret_cast<«instance.name»_t*>(BASE_ADDR+«instance.addressValue»UL);
                            }
                        «ENDIF»
                    «ENDIF»
                    «IF instance.range!==null»
                        «IF instantiation.isFilledByField»
                            static inline nonstd::span<uint«instantiation.size»_t, «instance.range.absSize»>& «instance.name»(){
                                return *reinterpret_cast<nonstd::span<uint«instantiation.size»_t, «instance.range.absSize»>*>(BASE_ADDR+«instance.addressValue»UL);
                            }
                        «ENDIF»
                        «IF !instantiation.isFilledByField»
                            static inline nonstd::span<«instance.name»_t, «instance.range.absSize»>& «instance.name»(){
                                return *reinterpret_cast<nonstd::span<«instance.name»_t, «instance.range.absSize»>*>(BASE_ADDR+«instance.addressValue»UL);
                            }
                        «ENDIF»
                    «ENDIF»
                «ENDFOR»
            «ENDFOR»
        };
        
        #endif // _«componentDefinition.name.toUpperCase»_H_
        '''
        
    override generateSource(String namespace) {
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