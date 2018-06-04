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
       
    def String generateHeader()
    
    def String generateSource()
    
}