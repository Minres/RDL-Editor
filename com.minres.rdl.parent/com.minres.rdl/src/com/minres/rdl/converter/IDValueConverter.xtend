package com.minres.rdl.converter

import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter
import org.eclipse.xtext.nodemodel.INode

class IDValueConverter extends AbstractLexerBasedConverter<String> {

	override protected String toEscapedString(String value) {
		return value
	}

	override String toValue(String string, INode node) {
		if(string.startsWith('\\'))
			return string.substring(1)
		else
			return string
	}
}
