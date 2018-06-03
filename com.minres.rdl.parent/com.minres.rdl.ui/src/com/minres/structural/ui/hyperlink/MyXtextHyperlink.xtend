package com.minres.structural.ui.hyperlink

import com.google.inject.Inject
import org.eclipse.xtext.ui.editor.IURIEditorOpener
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink

class MyXtextHyperlink extends XtextHyperlink {
		
	var boolean select = true
	
	@Inject var IURIEditorOpener uriEditorOpener;

	override void open() {
		uriEditorOpener.open(getURI(), select);
	}

	def boolean getSelectTarget(){
		return select
	}
	
	def void setSelectTarget(boolean select){
		this.select=select
	}
}