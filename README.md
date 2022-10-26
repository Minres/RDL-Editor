# RDL Editor

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

## How to use the standalone generator

You need to have Java 11 or newer available. To run the standalone generator simply call:

```
java -jar target/com.minres.rdl.standalone-1.4.0.jar -h
Usage: RDL2code [-h] [-v] [-f] [-I <RDL include dir>] [-o <output dir>] [-sc [-n <namespace>] [-sc-dir <dir modifier>]] [-fw [-fw-dir <dir modifier>]] <input file> <input file>
    The following switches are supported:
    -h                              prints help page
    -v                              verbose output
    -f                              force overwrite existing files
    -I <RDL include dir>            include directory to search included RDL files
    -o <output dir>                 output directory of generated files
    -fw                             generate FW include files. The following sub 
                                    switches are supported:
        -fw-dir <dir modifier>      set the directory modifier (relative path to output dir
    -sc                             generate SystemC stubs. The following sub switches
                                    are supported
        -n <namespace>              the namespace to use for the generated SystemC component
        -sc-dir <dir modifier>      set the directory modifier (relative path to output dir
```

Generating SystemC stubs becomes

```
java -jar com.minres.rdl.standalone-1.4.0.jar -o generated-src -sc -n 'sysc::myns' <RDL file>
```

The generated SystemcC sources can then be found in the (new) directory 'generated-src'.
