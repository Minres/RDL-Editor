package com.minres.structural.ui.hyperlink;

import com.google.inject.Inject;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink;

@SuppressWarnings("all")
public class MyXtextHyperlink extends XtextHyperlink {
  private boolean select = true;
  
  @Inject
  private IURIEditorOpener uriEditorOpener;
  
  @Override
  public void open() {
    this.uriEditorOpener.open(this.getURI(), this.select);
  }
  
  public boolean getSelectTarget() {
    return this.select;
  }
  
  public void setSelectTarget(final boolean select) {
    this.select = select;
  }
}
