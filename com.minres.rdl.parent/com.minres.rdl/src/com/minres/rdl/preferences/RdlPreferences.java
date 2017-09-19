package com.minres.rdl.preferences;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;

public class RdlPreferences {

	public static boolean getGenerateCsv() {
		return getPreferenceStore().getBoolean(PreferenceConstants.P_GENERATE_CSV, true);
	}

	public static String getAddrUnit() {
		return getPreferenceStore().get(PreferenceConstants.P_ADDRESSUNIT, System.getProperty(PreferenceConstants.ADDRESSUNIT_PROP));
	}

	public static IEclipsePreferences getPreferenceStore() {
		return InstanceScope.INSTANCE.getNode(PreferenceConstants.SCOPE_NAME);
	}
}