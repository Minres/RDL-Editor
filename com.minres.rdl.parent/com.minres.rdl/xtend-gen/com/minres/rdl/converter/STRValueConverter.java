package com.minres.rdl.converter;

import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;

@SuppressWarnings("all")
public class STRValueConverter extends AbstractLexerBasedConverter<String> {
  @Override
  protected String toEscapedString(final String value) {
    return (("\"" + value) + "\"");
  }
  
  @Override
  public String toValue(final String string, final INode node) {
    int _length = string.length();
    int _minus = (_length - 1);
    return string.substring(1, _minus);
  }
}
