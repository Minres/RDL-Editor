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