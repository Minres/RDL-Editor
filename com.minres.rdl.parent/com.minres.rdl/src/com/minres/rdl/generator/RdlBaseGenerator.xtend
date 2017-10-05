package com.minres.rdl.generator

import com.minres.rdl.rdl.ComponentDefinition
import com.minres.rdl.rdl.ExplicitPropertyAssignment
import com.minres.rdl.rdl.PropertyAssignment
import com.minres.rdl.rdl.PropertyEnum
import com.minres.rdl.IntegerWithRadix
import com.minres.rdl.rdl.Instantiation
import com.minres.rdl.rdl.PropertyAssignmentRhs
import com.minres.rdl.rdl.RValue
import com.minres.rdl.rdl.RValueConstant
import com.minres.rdl.rdl.InstancePropertyRef
import com.minres.rdl.rdl.ComponentDefinitionType

abstract class RdlBaseGenerator {
    
    def long accessWidth(ComponentDefinition definition){
        var size = 32L
        val pa = definition.propertyAssignments.findFirst[PropertyAssignment pa | 
            pa instanceof ExplicitPropertyAssignment && (pa as ExplicitPropertyAssignment).name==PropertyEnum.ACCESSWIDTH
        ]
        if(pa !== null){
            val sz = new IntegerWithRadix((pa as ExplicitPropertyAssignment).rhs.effectiveValue)
            size=sz.value
        }
        return size
    }

    def long regWidth(ComponentDefinition definition){
        var size = 32L
        val pa = definition.propertyAssignments.findFirst[PropertyAssignment pa | 
            pa instanceof ExplicitPropertyAssignment && (pa as ExplicitPropertyAssignment).name==PropertyEnum.REGWIDTH
        ]
        if(pa !== null){
            val sz = new IntegerWithRadix((pa as ExplicitPropertyAssignment).rhs.effectiveValue)
            size=sz.value
        }
        return size
    }

    def long getSize(Instantiation instantiation){
        val componentDef= instantiation.definingComponent
        switch (componentDef.type) {
            case ComponentDefinitionType.REG: {
                val pa = componentDef.propertyAssignments.findFirst[PropertyAssignment pa | 
                    pa instanceof ExplicitPropertyAssignment && (pa as ExplicitPropertyAssignment).name==PropertyEnum.REGWIDTH
                ]
                if(pa !== null){
                    val sz = new IntegerWithRadix((pa as ExplicitPropertyAssignment).rhs.effectiveValue)
                    return sz.value
                }
                return 32L
            }
            case ComponentDefinitionType.FIELD:{
                val pa = componentDef.propertyAssignments.findFirst[PropertyAssignment pa | 
                    pa instanceof ExplicitPropertyAssignment && (pa as ExplicitPropertyAssignment).name==PropertyEnum.FIELDWIDTH
                ]
                if(pa !== null){
                    val sz = new IntegerWithRadix((pa as ExplicitPropertyAssignment).rhs.effectiveValue)
                    return sz.value
                }
                return 1L
            }
            default: {
                return 0L;
            }
        }
    }
    
    def String effectiveName(ComponentDefinition definition){
        if(definition.name!==null){
           definition.name
        } else{
            val pa = definition.propertyAssignments.findFirst[PropertyAssignment pa | 
                pa instanceof ExplicitPropertyAssignment && (pa as ExplicitPropertyAssignment).name==PropertyEnum.NAME
            ]
            (pa as ExplicitPropertyAssignment).rhs.effectiveValue
        }
        
    }
    
    def String effectiveValue(PropertyAssignmentRhs rhs){
        if(rhs.value!== null)
            rhs.value.effectiveValue
        else if(rhs.instPropRef!==null)
            rhs.instPropRef.effectiveValue
        else if(rhs.enumRef!==null)
            rhs.enumRef.name
    }
    
    def String effectiveValue(RValue rvalue){
        if(rvalue.str!==null){
           rvalue.str
        } else if(rvalue.^val!=RValueConstant.UNDEFINED)
            rvalue.^val.literal
        else if(rvalue.num!==null){
            val num = rvalue.num as IntegerWithRadix
            num.toString
        }
    }
    
    def String effectiveValue(InstancePropertyRef ref){
        throw new RuntimeException()
    }
    
    def ComponentDefinition definingComponent(Instantiation instantiation){
        if(instantiation.componentRef!==null) instantiation.componentRef else instantiation.component
    }
    
       def int instanceCount(ComponentDefinition definition, ComponentDefinitionType type){
        definition.instantiationsOfType(type).map[it.componentInstances.size].reduce[p1, p2| p1+p2]
    }

    def instantiationsOfType(ComponentDefinition definition, ComponentDefinitionType type){
        definition.instantiations.filter[it.definingComponent.type == type]
    }

    def long byteSize(Instantiation instantiation, long start){
        val componentDefinition = instantiation.definingComponent
        var long componentSize=0;
        if(instantiation.definingComponent.type == ComponentDefinitionType.REG){
            componentSize=instantiation.definingComponent.regWidth/8
        } else 
            for(subInstantiation: componentDefinition.instantiations)
                componentSize = subInstantiation.byteSize(componentSize)
                
        var long lastTopAddress = start
        var long topAddress=start
        for(componentInstance: instantiation.componentInstances ){
            val byteSize = if(componentInstance.address !== null) (componentInstance.address as IntegerWithRadix).value+componentSize else componentSize + lastTopAddress
            topAddress = Math.max(topAddress, byteSize)
            lastTopAddress = byteSize
        }
        return topAddress
    }
    
    def long byteSize(Instantiation instantiation){
        val componentDefinition = instantiation.definingComponent
        var long componentSize=0;
        if(instantiation.definingComponent.type == ComponentDefinitionType.REG){
            componentSize=instantiation.definingComponent.regWidth/8
        } else 
            for(subInstantiation: componentDefinition.instantiations)
                componentSize = subInstantiation.byteSize(componentSize)
        return componentSize
    }
   
    def String generateHeader()
    
    def String generateSource()
    
}