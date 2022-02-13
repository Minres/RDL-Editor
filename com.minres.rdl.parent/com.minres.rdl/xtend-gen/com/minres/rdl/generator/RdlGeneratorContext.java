package com.minres.rdl.generator;

import org.eclipse.xtext.generator.GeneratorContext;

@SuppressWarnings("all")
public class RdlGeneratorContext extends GeneratorContext {
  public boolean forceOverwrite = false;
  
  public String namespace = "scc";
}
