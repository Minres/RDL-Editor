package com.minres.rdl.ui;

import org.eclipse.xtext.ui.XtextProjectHelper;

import com.minres.rdl.ui.wizard.RDLProjectCreator;


public class JDTFreeStructuralProjectCreator extends RDLProjectCreator {
	@Override
    protected String[] getProjectNatures() {
        return new String[] {XtextProjectHelper.NATURE_ID};
    }
	@Override
    protected String[] getBuilders() {
        return new String[] {XtextProjectHelper.BUILDER_ID};
    }
}
