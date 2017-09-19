package com.minres.rdl.ui

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider
import com.minres.rdl.rdl.ComponentDefinition
import com.minres.rdl.rdl.ComponentInstance
import com.minres.rdl.rdl.Instantiation

class RDLEObjectHoverProvider extends DefaultEObjectHoverProvider {
    override protected String getFirstLine(EObject o) {
        switch(o){
            ComponentDefinition: return 'Component '+o.name+' of type '+o.type.literal
            ComponentInstance: {
                val parent = o.eContainer
                if (parent instanceof Instantiation) {
                    return (if(parent.componentRef !== null) parent.componentRef.type else parent.component.type).literal.toFirstUpper+' '+o.name
                }
            }
        }
        return super.getFirstLine(o)
    }
}
