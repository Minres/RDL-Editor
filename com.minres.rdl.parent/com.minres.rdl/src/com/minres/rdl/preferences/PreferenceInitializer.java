package com.minres.rdl.preferences;

import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	private final HashSet<String> valid_addrunit_types = new HashSet<String>(Arrays.asList(new String[]{"byte", "word", "dword"}));
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#
	 * initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IEclipsePreferences store = InstanceScope.INSTANCE.getNode(PreferenceConstants.SCOPE_NAME);
		store.putBoolean(PreferenceConstants.P_GENERATE_CSV, true);
		String value = System.getProperty(PreferenceConstants.ADDRESSUNIT_PROP);
		if(valid_addrunit_types.contains(value)){
			store.put(PreferenceConstants.P_ADDRESSUNIT, value);
		} else {
			System.err.println("Unknown configuration value: '"+value+"', using 'byte'");
			store.put(PreferenceConstants.P_ADDRESSUNIT, "byte");
		}
		store.put(PreferenceConstants.P_NAMESPACE, "sysc");
		store.putBoolean(PreferenceConstants.P_OVERWRITE_STUBS, false);
		store.put(PreferenceConstants.P_FILETYPES_TO_GENERATE, "all");
		store.put(PreferenceConstants.P_COMPONENT_PATH, "");
		store.put(PreferenceConstants.P_FIRMWARE_PATH, "");
		store.put(PreferenceConstants.P_COPYRIGHT_HEADER, "Copyright (c) 2019 -2022 MINRES Technologies GmbH\n\nSPDX-License-Identifier: Apache-2.0");
	}

}
