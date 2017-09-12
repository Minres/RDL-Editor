package com.minres.rdl.converter

import org.eclipse.xtext.conversion.ValueConverterException
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.util.Strings
import com.minres.rdl.IntegerWithRadix

package class NUMValueConverter extends AbstractLexerBasedConverter<IntegerWithRadix> {

	override protected String toEscapedString(IntegerWithRadix value) {
		return value.toString()
	}

	override protected void assertValidValue(IntegerWithRadix value) {
		super.assertValidValue(value)
	}

	override IntegerWithRadix toValue(String string, INode node) throws ValueConverterException {
		if(Strings.isEmpty(string)) throw new ValueConverterException(
			"Couldn't convert empty string to an integer value.", node, null);
		try {
			return new IntegerWithRadix(string)
		} catch (NumberFormatException e) {
			throw new ValueConverterException('''Couldn't convert '«»«string»' to an integer value.''', node, e)
		}

	}
}
