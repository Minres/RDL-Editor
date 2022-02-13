package com.minres.rdl.generator

import com.minres.rdl.rdl.ComponentDefinition
import com.minres.rdl.rdl.ComponentDefinitionType

import static extension com.minres.rdl.RdlUtil.*

class ModuleGenerator extends RdlBaseGenerator {
    
    val ComponentDefinition componentDefinition
    
    new(ComponentDefinition definition) {
        componentDefinition=definition
    }
    
    override boolean getOverwrite(){
        false   
    }
    
    override generateHeader(String namespace){
        if(componentDefinition.type!=ComponentDefinitionType.REGFILE) return ''
        val addrMaps = componentDefinition.eResource.resourceSet.allContents
            .filter[ it instanceof ComponentDefinition]
            .map[it as ComponentDefinition]
            .filter[it.type == ComponentDefinitionType.ADDRMAP]
            .filter[def | def.instantiations.filter[it.componentRef==componentDefinition].size>0]
        if(addrMaps.size==0) return ''
        '''
            #ifndef _«namespace.toUpperCase»_«componentDefinition.effectiveName.toUpperCase»_H_
            #define _«namespace.toUpperCase»_«componentDefinition.effectiveName.toUpperCase»_H_
            #include <scc/tlm_target.h>
            
            namespace «namespace» {
            namespace gen {
            class «componentDefinition.effectiveName»_regs;
            }
            
            class «componentDefinition.effectiveName» : public sc_core::sc_module, public scc::tlm_target<> {
            public:
                sc_core::sc_in<sc_core::sc_time> clk_i{"clk_i"};
                sc_core::sc_in<bool> rst_i{"rst_i"};
                «componentDefinition.effectiveName»(sc_core::sc_module_name nm);
                virtual ~«componentDefinition.effectiveName»() override;
            
            protected:
                void clock_cb();
                void reset_cb();
                sc_core::sc_time clk;
                std::unique_ptr<gen::«componentDefinition.effectiveName»_regs> regs;
            };
            
            } /* namespace «namespace» */
            
            #endif /* _«namespace.toUpperCase»_«componentDefinition.effectiveName.toUpperCase»_H_ */
        '''
    }
	    
    override generateSource(String namespace) {
        if(componentDefinition.type!=ComponentDefinitionType.REGFILE) return ''
        val addrMaps = componentDefinition.eResource.resourceSet.allContents
            .filter[ it instanceof ComponentDefinition]
            .map[it as ComponentDefinition]
            .filter[it.type == ComponentDefinitionType.ADDRMAP]
            .filter[def | def.instantiations.filter[it.componentRef==componentDefinition].size>0]
        if(addrMaps.size==0) return ''
        '''
            /*
             * Copyright (c) 2019 -2022 MINRES Technologies GmbH
             *
             * SPDX-License-Identifier: Apache-2.0
             */
            
            #include "«componentDefinition.effectiveName».h"
            #include "gen/«componentDefinition.effectiveName».h"
            
            #include <scc/utilities.h>
            
            namespace «namespace» {
            SC_HAS_PROCESS(«componentDefinition.effectiveName»);// NOLINT
            
            «componentDefinition.effectiveName»::«componentDefinition.effectiveName»(sc_core::sc_module_name nm)
            : sc_core::sc_module(nm)
            , scc::tlm_target<>(clk)
            , NAMEDD(regs, gen::«componentDefinition.effectiveName»_regs) {
                regs->registerResources(*this);
                SC_METHOD(clock_cb);
                sensitive << clk_i;
                SC_METHOD(reset_cb);
                sensitive << rst_i;
            }

            «componentDefinition.effectiveName»::~«componentDefinition.effectiveName»() {} // NOLINT
            
            void «componentDefinition.effectiveName»::clock_cb() { this->clk = clk_i.read(); }
            
            void «componentDefinition.effectiveName»::reset_cb() {
                if (rst_i.read()) {
                    regs->reset_start();
                } else {
                    regs->reset_stop();
                }
            }
            
            } /* namespace «namespace» */
        '''
    }
}