package com.minres.rdl.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#
	 * initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IEclipsePreferences store = RdlPreferences.getPreferenceStore();
		store.putBoolean(PreferenceConstants.P_GENERATE_CSV, true);
		String value = System.getProperty(PreferenceConstants.ADDRESSUNIT_PROP);
		if(value!=null){
			if("byte".equals(value)){
				store.put(PreferenceConstants.P_ADDRESSUNIT, "byte");
			} else if("word".equals(value)){
				store.put(PreferenceConstants.P_ADDRESSUNIT, "word");
			} else if("dword".equals(value)){
				store.put(PreferenceConstants.P_ADDRESSUNIT, "dword");
			} else {
				System.err.println("Unknown configuration value: '"+value+"', using 'byte'");
				store.put(PreferenceConstants.P_ADDRESSUNIT, "byte");
			}
		} else 
			store.put(PreferenceConstants.P_ADDRESSUNIT, "byte");
	}

}
