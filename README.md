## RDL Editor

This is an editor for [SystemRDL](http://www.accellera.org/activities/working-groups/systemrdl/).

Quote from Accellera: "SystemRDL is designed to increase productivity, quality, and reuse during the design and development of complex digital systems. It can be used to share IP within and between groups, companies, and consortiums. This is accomplished by specifying a single source for the register description from which all views can be automatically generated, which ensures consistency between multiple views. A view is any output generated from the SystemRDL description, e.g., RTL code or documentation."

The editor is build on top of [Eclipse Xtext](http://www.eclipse.org/Xtext/), a framework to build **D**omain **S**pecific **L**anguages (DSL).

It has a code generator to create the register models using the [SC-Components](https://github.com/Minres/SystemC-Components) library. Due to the nature of Xtext this generator can easily be tailored to various needs.
