package com.minres.rdl.converter

import org.eclipse.xtext.common.services.DefaultTerminalConverters
import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.conversion.ValueConverter
import com.google.inject.Inject
import com.minres.rdl.IntegerWithRadix

class RdlTerminalConverters extends DefaultTerminalConverters {
	@Inject NUMValueConverter numValueConverter

	@Inject STRValueConverter stringConverter
	
	@Inject IDValueConverter idConverter
	
	@ValueConverter(rule="NUM") def IValueConverter<IntegerWithRadix> getNumValueConverter() {
		return numValueConverter
	}

	@ValueConverter(rule = "STR") def IValueConverter<String> getStrValueConverter() {
	  	return stringConverter;
	}

	@ValueConverter(rule = "ID") def IValueConverter<String> getIdValueConverter() {
	  	return idConverter;
	}
}
