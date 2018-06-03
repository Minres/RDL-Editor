/*
 * generated by Xtext 2.14.0
 */
package com.minres.rdl.ui

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.ui.wizard.IProjectCreator
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.ui.resource.SimpleResourceSetProvider
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper
import com.minres.structural.ui.hyperlink.MyHyperlinkHelper
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink
import com.minres.structural.ui.hyperlink.MyXtextHyperlink

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
class RDLUiModule extends AbstractRDLUiModule {

    def Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
        typeof(RDLEObjectHoverProvider);
    }
 
    def Class<? extends IEObjectDocumentationProvider> bindIEObjectDocumentationProviderr() {
        typeof(RDLEObjectDocumentationProvider);
    }

	override Class<? extends IProjectCreator> bindIProjectCreator() {
		return JDTFreeStructuralProjectCreator;
	}
	
	override Class<? extends IResourceSetProvider> bindIResourceSetProvider() {
    	return SimpleResourceSetProvider
  	}
  	
  	def Class<? extends HyperlinkHelper> bindHyperlinkHelper() {
		return MyHyperlinkHelper
	}
	
  	def Class<? extends XtextHyperlink> bindHyperlink() {
		return MyXtextHyperlink
	}
	
}
