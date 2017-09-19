import static groovy.io.FileType.FILES

// Collect all jars.
def jars = []
def root = new File(project.getBasedir(), 'target/classes')
def libs = new File(project.getBasedir(), 'target/classes/lib')

libs.eachFileRecurse (FILES) { file ->
  jars << root.toURI().relativize(file.toURI()).toString()
}

// Write the manifest file.
def manifest = new File(project.getBasedir(), 'target/classes/META-INF/MANIFEST.MF')

manifest.write ''

manifest << 'Manifest-Version: 1.0\n'
manifest << 'Class-Path: . ' + jars.join(' ') + '\n'
manifest << 'Rsrc-Main-Class: com.minres.rdl.generator.Main\n'
manifest << 'Main-Class: org.eclipse.jdt.internal.jarinjarloader.JarRsrcLoader\n'