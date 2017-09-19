package com.minres.rdl.ui.preferences;

import com.minres.rdl.preferences.PreferenceConstants;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

@SuppressWarnings("all")
public class RdlPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
  public RdlPreferencePage() {
    super(FieldEditorPreferencePage.GRID);
    final ScopedPreferenceStore store = new ScopedPreferenceStore(InstanceScope.INSTANCE, "com.minres.rdl.rdl");
    this.setPreferenceStore(store);
    this.setDescription("Code generator configuration options");
  }
  
  @Override
  public void createFieldEditors() {
    Composite _fieldEditorParent = this.getFieldEditorParent();
    BooleanFieldEditor _booleanFieldEditor = new BooleanFieldEditor(PreferenceConstants.P_GENERATE_CSV, "Generate CSV:", _fieldEditorParent);
    this.addField(_booleanFieldEditor);
    Composite _fieldEditorParent_1 = this.getFieldEditorParent();
    ComboFieldEditor _comboFieldEditor = new ComboFieldEditor(PreferenceConstants.P_ADDRESSUNIT, "Address unit size", new String[][] { new String[] { "Byte (8bit)", "byte" }, new String[] { "Word (16bit)", "word" }, new String[] { "DWord (32bit)", "dword" } }, _fieldEditorParent_1);
    this.addField(_comboFieldEditor);
  }
  
  @Override
  public void init(final IWorkbench workbench) {
  }
}
