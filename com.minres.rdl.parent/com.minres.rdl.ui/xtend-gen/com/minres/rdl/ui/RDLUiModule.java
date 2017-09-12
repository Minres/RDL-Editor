/**
 * generated by Xtext 2.12.0
 */
package com.minres.rdl.ui;

import com.minres.rdl.ui.AbstractRDLUiModule;
import com.minres.rdl.ui.RDLEObjectDocumentationProvider;
import com.minres.rdl.ui.RDLEObjectHoverProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class RDLUiModule extends AbstractRDLUiModule {
  public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
    return RDLEObjectHoverProvider.class;
  }
  
  public Class<? extends IEObjectDocumentationProvider> bindIEObjectDocumentationProviderr() {
    return RDLEObjectDocumentationProvider.class;
  }
  
  public RDLUiModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
}