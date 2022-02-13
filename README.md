## RDL Editor

This is an editor for [SystemRDL](http://www.accellera.org/activities/working-groups/systemrdl/).
It can be installed into any Eclipse installation using the following update site url: https://minres.github.io/RDL-Editor/repository

According to Accellera:

> SystemRDL is designed to increase productivity, quality, and reuse during the design and development of complex digital systems.
> It can be used to share IP within and between groups, companies, and consortiums.
> This is accomplished by specifying a single source for the register description from which all views can be automatically generated,
> which ensures consistency between multiple views. A view is any output generated from the SystemRDL description, e.g., RTL code or documentation.

The source code can be found at [Github](https://github.com/Minres/RDL-Editor/).
The editor is build on top of [Eclipse Xtext](http://www.eclipse.org/Xtext/), a framework to build **D**omain **S**pecific **L**anguages (DSL).

It has a code generator to create the register models using the [SC-Components](https://minres.github.io/SystemC-Components/) library.
Due to the nature of Xtext this generator can easily be tailored to various needs.
