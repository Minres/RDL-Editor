import static groovy.io.FileType.FILES

import java.nio.file.Files
import java.nio.file.Paths
import java.util.zip.ZipEntry

def needed_jars = [
	/org\.eclipse\.xtext/,
	/org\.eclipse\.emf\.ecore\.xmi/,
	/org\.eclipse\.emf\.ecore/,
	/org\.eclipse\.emf\.common/,
	/org\.antlr\.runtime/,
	/com\.google\.inject/,
	/org\.eclipse\.emf\.mwe\.core/,
	/org\.apache\.commons\.cli/,
	/org\.eclipse\.emf\.mwe2\.runtime/,
	/org\.eclipse\.emf\.mwe\.utils/,
	/org\.eclipse\.xtext\.util/,
	/com\.google\.guava/,
	/javax\.inject/,
	/org\.eclipse\.xtext\.xbase/,
	/org\.eclipse\.xtext\.common\.types/,
	/org\.eclipse\.xtend\.lib/,
	/org\.eclipse\.xtext\.xbase\.lib/,
	/org\.eclipse\.xtend\.lib\.macro/,
	/org\.eclipse\.equinox\.common/,
	/eclipse-trace/,
	/groovy-eclipse/,
	/ivy-2\.5\.0\.jar/,
	/groovy-3\.0\.\d-indy/,
	/groovy-templates-3\.0\.\d/,
	/org\.eclipse\.xtext\.xtext\.generator/,
	/org\.eclipse\.emf\.codegen\.ecore/,
	/org\.eclipse\.emf\.codegen/,
	/org\.eclipse\.emf\.mwe2\.launch/,
	/org\.eclipse\.emf\.mwe2\.language/,
	/org\.eclipse\.emf\.mwe2\.lib/,
	/org\.objectweb\.asm/,
	/org\.apache\.commons\.logging/,
	/org\.apache\.log4j/,
	/com\.ibm\.icu/,
	/org\.json/,
	/com\.minres\.rdl/
]

// Collect all jars.
def jars = []
def root = new File(project.getBasedir(), 'target/classes')
def libs = new File(project.getBasedir(), 'target/classes/lib')
def meta_inf = new File(project.getBasedir(), 'target/classes/META-INF')

libs.eachFileRecurse (FILES) { file ->
	if(file.name =~/org\.codehaus\.groovy_/) { // we need to unpack this one sinc it is already jar in jar
		println("Unpacking ${file}")
		def zipFile = new java.util.zip.ZipFile(file)
		zipFile.entries().findAll {ZipEntry entry -> !entry.directory && entry.name =~/\.jar$/}.each {ZipEntry entry ->
			def outFile = new File(libs, entry.name.split(/\//)[-1])
			println "Extracting file ${entry.name} to ${outFile.path} with size ${entry.size}bytes (${entry.compressedSize}bytes)"
			Files.copy(zipFile.getInputStream(entry), outFile.toPath())
		}
	}
}
libs.eachFileRecurse (FILES) { file ->
	def fileName = file.name.split("/")[-1]
	if(needed_jars.find{fileName =~ it}) {
		println "Adding $file to the included jars"
		jars << root.toURI().relativize(file.toURI()).toString()
	} else {
		file.delete()
	}
}
def zipFile = new java.util.zip.ZipFile(new File(project.getBasedir(), 'jar-in-jar-loader.zip'))
zipFile.entries().each {ZipEntry it ->
	def path = Paths.get("${root}/", it.name)
	if(it.directory){
		Files.createDirectories(path)
	} else {
		def parentDir = path.getParent()
		if (!Files.exists(parentDir)) {
			Files.createDirectories(parentDir)
		}
		Files.deleteIfExists(path)
		println "Extracting file ${it.name} to ${path} with size ${it.size}bytes (${it.compressedSize}bytes)"
		Files.copy(zipFile.getInputStream(it), path)
	}
}

// Write the manifest file.
Files.createDirectories( Paths.get(meta_inf.absolutePath))
def mf = new File(project.getBasedir(), 'target/classes/META-INF/MANIFEST.MF')
mf.write ''
mf << 'Manifest-Version: 1.0\n'
mf << 'Rsrc-Class-Path: ./ ' + jars.join(' ') + '\n'
mf << 'Rsrc-Main-Class: com.minres.rdl.generator.Main\n'
mf << 'Main-Class: org.eclipse.jdt.internal.jarinjarloader.JarRsrcLoader\n'
