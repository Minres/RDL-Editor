package com.minres.rdl.generator

import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.generator.IGeneratorContext

class RdlGeneratorContext implements IGeneratorContext {

    public boolean forceOverwrite = false
    
    public String namespace ="sysc"
    
    public CancelIndicator cancelIndicator;
    
    public boolean generateFw = true;
    
    public String fwPathModifier = ""
    
    public boolean generateSc = true;
    
    public String scPathModifier =""
    
    override getCancelIndicator() {
        return cancelIndicator
    }
    
}