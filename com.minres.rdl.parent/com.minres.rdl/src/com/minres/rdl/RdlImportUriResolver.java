package com.minres.rdl;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;

public class RdlImportUriResolver extends ImportUriResolver {
	
	private static final Logger LOGGER = Logger.getLogger(RdlImportUriResolver.class);
	
	public RdlImportUriResolver() {
		super();
		LOGGER.setLevel(Level.INFO);
	}
	
	@Override
	public String resolve(EObject object) {
		return super.resolve(object);
	}
}
