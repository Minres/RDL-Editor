package com.minres.rdl.ui

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider

class RDLEObjectDocumentationProvider implements IEObjectDocumentationProvider {
	override String getDocumentation(EObject o) {
		// if (o instanceof Greeting) {
		// return "This is a nice Greeting with nice <b>markup</b> in the <i>documentation</i>";
		// }
		return null
	}
}
