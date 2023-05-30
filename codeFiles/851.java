plugins {    id 'java'    id 'maven-publish'}group 'org.simple.processor'version '1.0-SNAPSHOT'repositories {    mavenLocal()}publishing {    publications {        maven(MavenPublication) {        }    }    repositories {        mavenLocal()    }}compileJava {    options.annotationProcessorPath = configurations.annotationProcessor}sourceCompatibility = JavaVersion.VERSION_17targetCompatibility = JavaVersion.VERSION_17tasks.withType(JavaCompile) {    options.compilerArgs += [&quot;--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED&quot;]    options.compilerArgs += [&quot;--add-exports=jdk.compiler/com.sun.tools.javac.processing=ALL-UNNAMED&quot;]    options.compilerArgs += [&quot;--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED&quot;]    options.compilerArgs += [&quot;--add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED&quot;]}