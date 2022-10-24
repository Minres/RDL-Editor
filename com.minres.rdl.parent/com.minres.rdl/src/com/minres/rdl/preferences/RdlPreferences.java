package com.minres.rdl.preferences;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;

public class RdlPreferences {

	public static IEclipsePreferences getPreferenceStore() {
		return InstanceScope.INSTANCE.getNode(PreferenceConstants.SCOPE_NAME);
	}

	public static boolean getGenerateCsv() {
		return getPreferenceStore().getBoolean(PreferenceConstants.P_GENERATE_CSV, true);
	}

	public static String getAddrUnit() {
		return getPreferenceStore().get(PreferenceConstants.P_ADDRESSUNIT, System.getProperty(PreferenceConstants.ADDRESSUNIT_PROP));
	}

	public static String getNamespace() {
		return getPreferenceStore().get(PreferenceConstants.P_NAMESPACE, "sysc");
	}

	public static boolean getOverwriteStubs() {
		return getPreferenceStore().getBoolean(PreferenceConstants.P_OVERWRITE_STUBS, false);
	}

	public static int getFielTypesToGenerate() {
		return getPreferenceStore().getInt(PreferenceConstants.P_FILETYPES_TO_GENERATE, 3);
	}

	public static String getComponentPath() {
		return getPreferenceStore().get(PreferenceConstants.P_COMPONENT_PATH, "");
	}

	public static String getFirmwarePath() {
		return getPreferenceStore().get(PreferenceConstants.P_FIRMWARE_PATH, "");
	}
}