package com.minres.rdl.converter;

import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;

@SuppressWarnings("all")
public class IDValueConverter extends AbstractLexerBasedConverter<String> {
  @Override
  protected String toEscapedString(final String value) {
    return value;
  }
  
  @Override
  public String toValue(final String string, final INode node) {
    boolean _startsWith = string.startsWith("\\");
    if (_startsWith) {
      return string.substring(1);
    } else {
      return string;
    }
  }
}
