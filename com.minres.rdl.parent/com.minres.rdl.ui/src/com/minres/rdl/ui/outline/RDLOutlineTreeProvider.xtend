/*
 * generated by Xtext 2.14.0
 */
package com.minres.rdl.ui.outline

import com.minres.rdl.rdl.Root
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode
import com.minres.rdl.rdl.ComponentDefinition
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import com.minres.rdl.rdl.ExplicitPropertyAssignment
import com.minres.rdl.rdl.PostPropertyAssignment
import com.minres.rdl.rdl.PropertyAssignmentRhs
import com.minres.rdl.rdl.EnumDefinition
import com.minres.rdl.rdl.EnumEntry
import com.minres.rdl.rdl.Instantiation
import com.minres.rdl.rdl.ComponentInstance

/**
 * Customization of the default outline structure.
 *
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#outline
 */
class RDLOutlineTreeProvider extends DefaultOutlineTreeProvider {

    protected def _createChildren(DocumentRootNode parentNode, Root domainModel) {
      domainModel.enumDefinitions.forEach[createNode(parentNode, it)]
      domainModel.propertyDefinitions.forEach[createNode(parentNode, it)]
      domainModel.componentDefinitions.forEach[createNode(parentNode, it)]
      domainModel.propertyAssignments.forEach[createNode(parentNode, it)]
      domainModel.instantiations.forEach[Instantiation instantiation |
          if(instantiation.component!==null) createNode(parentNode, instantiation.component)
          instantiation.componentInstances.forEach[createNode(parentNode, it)]
      ]
    }
    
    protected def _createChildren(IOutlineNode parentNode, ComponentDefinition compDef) {
      compDef.enumDefinitions.forEach[createNode(parentNode, it)]
      compDef.componentDefinitions.forEach[createNode(parentNode, it)]
      compDef.propertyAssignments.forEach[createNode(parentNode, it)]
      compDef.instantiations.forEach[Instantiation instantiation |
          if(instantiation.component!==null) createNode(parentNode, instantiation.component)
          instantiation.componentInstances.forEach[createNode(parentNode, it)]
      ]
    }

    protected def _createChildren(IOutlineNode parentNode, EnumDefinition e) {
    	e.body.entries.forEach[createNode(parentNode, it)]
    }
    
    protected def _createChildren(IOutlineNode parentNode, PostPropertyAssignment p) {
    	createNode(parentNode, p.rhs)
    }
    
    protected def boolean _isLeaf(ExplicitPropertyAssignment feature) {
  		return true;
	}
	
    protected def boolean _isLeaf(Instantiation feature) {
  		return feature.component===null && feature.componentInstances.size==0;
	}

    protected def boolean _isLeaf(PropertyAssignmentRhs feature) {
  		return true;
	}

    protected def boolean _isLeaf(ComponentInstance feature) {
        return true;
    }
 
    protected def boolean _isLeaf(EnumEntry feature) {
  		return feature.properties.size==0;
	}
}