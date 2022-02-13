package com.minres.rdl.converter;

import com.google.inject.Inject;
import com.minres.rdl.IntegerWithRadix;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;

@SuppressWarnings("all")
public class RdlTerminalConverters extends DefaultTerminalConverters {
  @Inject
  private NUMValueConverter numValueConverter;
  
  @Inject
  private STRValueConverter stringConverter;
  
  @Inject
  private IDValueConverter idConverter;
  
  @ValueConverter(rule = "NUM")
  public IValueConverter<IntegerWithRadix> getNumValueConverter() {
    return this.numValueConverter;
  }
  
  @ValueConverter(rule = "STR")
  public IValueConverter<String> getStrValueConverter() {
    return this.stringConverter;
  }
  
  @ValueConverter(rule = "ID")
  public IValueConverter<String> getIdValueConverter() {
    return this.idConverter;
  }
}
