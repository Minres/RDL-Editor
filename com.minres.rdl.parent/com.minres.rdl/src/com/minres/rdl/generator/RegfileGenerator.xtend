package com.minres.rdl.generator

import com.minres.rdl.IntegerWithRadix
import com.minres.rdl.rdl.ComponentDefinition
import com.minres.rdl.rdl.ComponentDefinitionType
import com.minres.rdl.rdl.ComponentInstance
import com.minres.rdl.rdl.Instantiation
import java.util.Date

import static extension com.minres.rdl.RdlUtil.*

class RegfileGenerator extends RdlBaseGenerator{
    
    val ComponentDefinition componentDefinition
    
    new(ComponentDefinition definition) {
        componentDefinition=definition
    }
    
    override boolean getOverwrite(){
        true   
    }
    
    override String generateHeader(String namespace)'''
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
        
        #include <scc/utilities.h>
        #include <util/bit_field.h>
        #include <scc/register.h>
        #include <scc/tlm_target.h>
        «FOR instantiation : componentDefinition.instantiations»
            «IF instantiation.componentDefinition.type == ComponentDefinitionType.REGFILE»
                #include "«instantiation.componentDefinition.effectiveName».h"
            «ENDIF»
        «ENDFOR»
        
        «FOR ns : namespace.split('::')»
        namespace «ns» {
        «ENDFOR»
        namespace gen {
        
        class «componentDefinition.effectiveName»_regs :
                public sc_core::sc_module,
                public scc::resetable
        {
        public:
            //////////////////////////////////////////////////////////////////////////////
            // storage declarations
            //////////////////////////////////////////////////////////////////////////////
            «FOR cdef : componentDefinition.componentDefinitions»
                «IF cdef.type == ComponentDefinitionType.REG»
                    BEGIN_BF_DECL(«cdef.effectiveName»+'_t'», uint«cdef»_t);
                    «cdef.genFieldDeclarations»
                    END_BF_DECL();
                «ENDIF»
            «ENDFOR»
            «FOR instantiation : componentDefinition.instantiations»
                «IF instantiation.componentDefinition.type == ComponentDefinitionType.REGFILE»
                    «FOR instance : instantiation.componentInstances»
                        «instantiation.componentDefinition.effectiveName»_regs i_«instance.name»{"«instance.name»"};
                    «ENDFOR»
                «ELSEIF instantiation.componentDefinition.type == ComponentDefinitionType.REG»
                    «IF instantiation.isFilledByField»
                        «IF instantiation.componentInstances.filter[it.range===null].size>0»
                            uint«instantiation.size»_t «instantiation.componentInstances.filter[it.range===null].map['r_'+it.name].join(', ')»;
                        «ENDIF»
                        «FOR componentInstance : instantiation.componentInstances.filter[it.range!==null]»
                            std::array<uint«instantiation.size»_t, «componentInstance.range.absSize»> r_«componentInstance.name»;
                        «ENDFOR»
                    «ELSEIF instantiation.componentDefinition.instantiations.size==0»
                        «IF instantiation.componentInstances.filter[it.range===null].size>0»
                            uint«instantiation.size»_t «instantiation.componentInstances.filter[it.range===null].map['r_'+it.name].join(', ')»;
                        «ENDIF»
                        «FOR componentInstance : instantiation.componentInstances.filter[it.range!==null]»
                            std::array<uint«instantiation.size»_t, «componentInstance.range.absSize»> r_«componentInstance.name»;
                        «ENDFOR»
                    «ELSE»
                        BEGIN_BF_DECL(«instantiation.component.effectiveName»_t, uint«instantiation.size»_t);
                            «instantiation.definingComponent.genFieldDeclarations»
                        END_BF_DECL() «instantiation.componentInstances.filter[it.range===null].map['r_'+it.name].join(', ')»;
                        «FOR componentInstance : instantiation.componentInstances.filter[it.range!==null]»
                            std::array<«instantiation.component.effectiveName»_t, «componentInstance.range.absSize»> r_«componentInstance.name»;
                        «ENDFOR»
                    «ENDIF»
                «ENDIF»
            «ENDFOR»
            //////////////////////////////////////////////////////////////////////////////
            // register declarations
            //////////////////////////////////////////////////////////////////////////////
            «FOR instantiation : componentDefinition.instantiations»
                «FOR instance : instantiation.componentInstances»
                    «IF instantiation.componentDefinition.type == ComponentDefinitionType.REGFILE»
                        // scc::sc_register_file<«instantiation.componentDefinition.effectiveName»_regs> «instance.name»;
                    «ELSEIF instantiation.componentDefinition.type == ComponentDefinitionType.REG»
                        «IF instance.range===null»
                            «IF instantiation.componentDefinition.instantiations.size==0»
                                scc::sc_register<uint«instantiation.size»_t> «instance.name»;
                            «ELSEIF instantiation.isFilledByField»
                                scc::sc_register<uint«instantiation.size»_t> «instance.name»;
                            «ELSE»
                                scc::sc_register<«instantiation.componentDefinition.effectiveName»_t> «instance.name»;
                            «ENDIF»
                        «ELSE»
                            «IF instantiation.componentDefinition.instantiations.size==0»
                                scc::sc_register_indexed<uint«instantiation.size»_t, «instance.range.absSize»> «instance.name»;
                            «ELSEIF instantiation.isFilledByField»
                                scc::sc_register_indexed<uint«instantiation.size»_t, «instance.range.absSize»> «instance.name»;
                            «ELSE»
                                scc::sc_register_indexed<«instantiation.component.effectiveName»_t, «instance.range.absSize»> «instance.name»;
                            «ENDIF»
                        «ENDIF»
                    «ENDIF»
                «ENDFOR»
            «ENDFOR»
            
            «componentDefinition.effectiveName»_regs(sc_core::sc_module_name nm);
        
            template<unsigned BUSWIDTH=32>
            void registerResources(scc::tlm_target<BUSWIDTH>& target, uint64_t offset=0);
        };
        } // namespace gen
        «FOR ns : namespace.split('::').reverse»
        } // namespace «ns»
        «ENDFOR»
        //////////////////////////////////////////////////////////////////////////////
        // member functions
        //////////////////////////////////////////////////////////////////////////////
        
        inline «namespace»::gen::«componentDefinition.effectiveName»_regs::«componentDefinition.effectiveName»_regs(sc_core::sc_module_name nm)
        : sc_core::sc_module(nm)
        «FOR instantiation : componentDefinition.instantiations»
            «FOR instance : instantiation.componentInstances»
                «IF instantiation.componentDefinition.type == ComponentDefinitionType.REGFILE»
                     // , NAMED(«instance.name», i_«instance.name», 0, *this)
                «ELSEIF instantiation.componentDefinition.type == ComponentDefinitionType.REG»
                    , NAMED(«instance.name», r_«instance.name», 0, *this)
                «ENDIF»
            «ENDFOR»
        «ENDFOR»
        {
        }
        
        template<unsigned BUSWIDTH>
        inline void «namespace»::gen::«componentDefinition.effectiveName»_regs::registerResources(scc::tlm_target<BUSWIDTH>& target, uint64_t offset) {
            «FOR instantiation : componentDefinition.instantiations»
                «FOR instance : instantiation.componentInstances»
                    «IF instantiation.componentDefinition.type == ComponentDefinitionType.REGFILE»
                        i_«instance.name».registerResources(target, «instance.addressValue»UL+offset);
                    «ELSEIF instantiation.componentDefinition.type == ComponentDefinitionType.REG»
                        target.addResource(«instance.name», «instance.addressValue»UL+offset);
                    «ENDIF»                    
                «ENDFOR»
            «ENDFOR»
        }
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