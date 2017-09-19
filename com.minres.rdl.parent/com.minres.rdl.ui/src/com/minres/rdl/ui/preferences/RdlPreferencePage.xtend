package com.minres.rdl.ui.preferences

import org.eclipse.jface.preference.FieldEditorPreferencePage
import org.eclipse.ui.IWorkbenchPreferencePage
import org.eclipse.ui.IWorkbench
import org.eclipse.jface.preference.BooleanFieldEditor
import com.minres.rdl.preferences.PreferenceConstants
import org.eclipse.ui.preferences.ScopedPreferenceStore
import org.eclipse.core.runtime.preferences.InstanceScope
import org.eclipse.jface.preference.ComboFieldEditor

class RdlPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	
	new() {
		super(GRID)
	    val store = new ScopedPreferenceStore(InstanceScope.INSTANCE, PreferenceConstants.SCOPE_NAME);
	    setPreferenceStore(store);
	    setDescription("Code generator configuration options");
	}
	
	override createFieldEditors() {
    	addField(new BooleanFieldEditor(PreferenceConstants.P_GENERATE_CSV, "Generate CSV:", getFieldEditorParent()));
    	addField(new ComboFieldEditor(PreferenceConstants.P_ADDRESSUNIT, "Address unit size", #[#["Byte (8bit)","byte"], #["Word (16bit)","word"], #["DWord (32bit)","dword"]], getFieldEditorParent()))
	}
	
	override init(IWorkbench workbench) {
	}
	
}