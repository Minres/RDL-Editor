package com.minres.rdl.ui

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider
import com.minres.rdl.rdl.ComponentDefinition
import com.minres.rdl.rdl.ComponentInstance
import com.minres.rdl.rdl.ImmediateInstantiation
import com.minres.rdl.rdl.NamedInstantiation

class RDLEObjectHoverProvider extends DefaultEObjectHoverProvider {
	override protected String getFirstLine(EObject o) {
		switch(o){
			ComponentDefinition: return 'Component '+o.name+' of type '+o.type.literal
			ComponentInstance: {
					val parent = o.eContainer
					if (parent instanceof ImmediateInstantiation) {
						val compDef = parent.eContainer as ComponentDefinition
						return compDef.type.literal+' '+o.name
					} else if (parent instanceof NamedInstantiation) {
						return parent.component.type.literal+' '+o.name
					}
			}
		}
		return super.getFirstLine(o)
	}
}
