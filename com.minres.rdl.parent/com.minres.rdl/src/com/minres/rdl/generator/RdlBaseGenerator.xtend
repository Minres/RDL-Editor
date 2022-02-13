package com.minres.rdl.generator

abstract class RdlBaseGenerator {
       
    def String generateHeader(String namespace)
    
    def String generateSource(String namespace)
    
    def boolean getOverwrite()
    
}