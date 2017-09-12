package com.minres.rdl.converter;

import com.minres.rdl.IntegerWithRadix;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
class NUMValueConverter extends AbstractLexerBasedConverter<IntegerWithRadix> {
  @Override
  protected String toEscapedString(final IntegerWithRadix value) {
    return value.toString();
  }
  
  @Override
  protected void assertValidValue(final IntegerWithRadix value) {
    super.assertValidValue(value);
  }
  
  @Override
  public IntegerWithRadix toValue(final String string, final INode node) throws ValueConverterException {
    boolean _isEmpty = Strings.isEmpty(string);
    if (_isEmpty) {
      throw new ValueConverterException(
        "Couldn\'t convert empty string to an integer value.", node, null);
    }
    try {
      return new IntegerWithRadix(string);
    } catch (final Throwable _t) {
      if (_t instanceof NumberFormatException) {
        final NumberFormatException e = (NumberFormatException)_t;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Couldn\'t convert \'");
        _builder.append(string);
        _builder.append("\' to an integer value.");
        throw new ValueConverterException(_builder.toString(), node, e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
