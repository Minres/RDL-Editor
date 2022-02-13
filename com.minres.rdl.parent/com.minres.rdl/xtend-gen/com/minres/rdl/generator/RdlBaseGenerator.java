package com.minres.rdl.generator;

@SuppressWarnings("all")
public abstract class RdlBaseGenerator {
  public abstract String generateHeader(final String namespace);
  
  public abstract String generateSource(final String namespace);
  
  public abstract boolean getOverwrite();
}
