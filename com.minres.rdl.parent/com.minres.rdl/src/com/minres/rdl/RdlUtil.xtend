package com.minres.rdl

import com.minres.rdl.rdl.ComponentInstance
import com.minres.rdl.rdl.ComponentDefinition
import com.minres.rdl.rdl.ExplicitPropertyAssignment
import com.minres.rdl.rdl.PropertyAssignment
import com.minres.rdl.rdl.Instantiation
import com.minres.rdl.rdl.ComponentDefinitionType
import com.minres.rdl.rdl.PropertyEnum
import com.minres.rdl.rdl.PropertyAssignmentRhs
import com.minres.rdl.rdl.RValue
import com.minres.rdl.rdl.RValueConstant
import com.minres.rdl.rdl.InstancePropertyRef
import com.minres.rdl.rdl.Range

class RdlUtil {
	
	static def IntegerWithRadix addressValue(ComponentInstance instance) {
		if (instance.address !== null)
			return instance.address as IntegerWithRadix
		else
			return new IntegerWithRadix(0)
	}

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

    static def long regWidth(ComponentDefinition definition){
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

    static def long getSize(Instantiation instantiation){
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
    
    static def String effectiveName(ComponentDefinition definition){
        if(definition.name!==null){
           return definition.name.replaceAll('\\s+', '_')
        } else{
            val pa = definition.propertyAssignments.findFirst[PropertyAssignment pa | 
                pa instanceof ExplicitPropertyAssignment && (pa as ExplicitPropertyAssignment).name==PropertyEnum.NAME
            ]
            if(pa !== null)
            	return (pa as ExplicitPropertyAssignment).rhs.effectiveValue.replaceAll('\\s+', '_')
            else
            	return ('unnamed_'+definition.type).replaceAll('\\s+', '_')
        }
    }
    
    static def String effectiveValue(PropertyAssignmentRhs rhs){
        if(rhs.value!== null)
            rhs.value.effectiveValue
        else if(rhs.instPropRef!==null)
            rhs.instPropRef.effectiveValue
        else if(rhs.enumRef!==null)
            rhs.enumRef.name
    }
    
    static def String effectiveValue(RValue rvalue){
        if(rvalue.str!==null){
           rvalue.str
        } else if(rvalue.^val!=RValueConstant.UNDEFINED)
            rvalue.^val.literal
        else if(rvalue.num!==null){
            val num = rvalue.num as IntegerWithRadix
            num.toString
        }
    }
    
    static def String effectiveValue(InstancePropertyRef ref){
        throw new RuntimeException()
    }
    
    static def ComponentDefinition definingComponent(Instantiation instantiation){
        if(instantiation.componentRef!==null) instantiation.componentRef else instantiation.component
    }
    
    static def int instanceCount(ComponentDefinition definition, ComponentDefinitionType type){
        definition.instantiationsOfType(type).map[it.componentInstances.size].reduce[p1, p2| p1+p2]
    }

    static def instantiationsOfType(ComponentDefinition definition, ComponentDefinitionType type){
        definition.instantiations.filter[it.definingComponent.type == type]
    }

    static def long byteSize(Instantiation instantiation, long start){
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
    
    static def long byteSize(Instantiation instantiation){
        val componentDefinition = instantiation.definingComponent
        var long componentSize=0;
        if(instantiation.definingComponent.type == ComponentDefinitionType.REG){
            componentSize=instantiation.definingComponent.regWidth/8
        } else 
            for(subInstantiation: componentDefinition.instantiations)
                componentSize = subInstantiation.byteSize(componentSize)
        return componentSize
    }

    static def ComponentDefinition getComponentDefinition(Instantiation instantiation) {
        if(instantiation.component!==null) instantiation.component else instantiation.componentRef
    }
    
    static def long absSize(Range range){
        if(range.size!==null) 
            return (range.size as IntegerWithRadix).value 
        else
           return Math.abs((range.left as IntegerWithRadix).value - (range.right as IntegerWithRadix).value)+1 
    }
    
    static def boolean isFilledByField(Instantiation instantiation){
        val fieldCount = instantiation.componentDefinition.instanceCountOfType(ComponentDefinitionType.FIELD)
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
                
    static def int instanceCountOfType(ComponentDefinition definition, ComponentDefinitionType type){
        val insts = definition.instantiationsOfType(type)
        if(insts.size>0) {
            insts.map[it.componentInstances.size].reduce[p1, p2| p1+p2]
        } else
            0
    }
}