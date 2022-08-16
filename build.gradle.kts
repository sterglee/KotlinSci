

val kotlinVersion = "1.7.10"

plugins {

    java
    application
    kotlin("jvm") version "1.7.10"
}
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(16))

    }
}


tasks.withType<JavaCompile> {
    val compilerArgs = options.compilerArgs
    compilerArgs.addAll(listOf("--add-modules", "jdk.incubator.vector"))
}


repositories {
        mavenCentral()
        jcenter()
    }


    dependencies {

        implementation("org.jetbrains.kotlin:kotlin-main-kts:$kotlinVersion")
        implementation("org.jetbrains.kotlin:kotlin-scripting-jsr223:$kotlinVersion")
        implementation  ("org.jline:jline:3.21.0")
        implementation  ("org.fusesource.jansi:jansi:2.4.0")
        implementation   ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
        implementation   ("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
        implementation   ("org.jetbrains.kotlin:kotlin-script-runtime:$kotlinVersion")
        implementation   ("org.jetbrains.kotlin:kotlin-scripting-common:$kotlinVersion")
        implementation   ("org.jetbrains.kotlin:kotlin-scripting-jvm:$kotlinVersion")
        implementation   ("org.jetbrains.kotlin:kotlin-scripting-jvm-host:$kotlinVersion")
        implementation   ("org.jetbrains.kotlin:kotlin-scripting-dependencies:$kotlinVersion")
        implementation   ("org.jetbrains.kotlin:kotlin-scripting-dependencies-maven-all:$kotlinVersion")
        implementation   ("org.jetbrains.kotlin:kotlin-scripting-compiler-embeddable:$kotlinVersion")
        implementation   ("org.jetbrains.kotlin:kotlin-scripting-ide-services:$kotlinVersion")
        implementation   ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.3")
        implementation   ("junit:junit:4.13.2")
        implementation   ("org.antlr:antlr4-runtime:4.8-1")
        implementation   ("org.slf4j:slf4j-simple:1.7.36")




}

application {
    mainClassName = "org.jetbrains.kotlin.ki.shell.KotlinShell"
}
  



sourceSets {
    main {
        java.srcDir("ki-shell/src/main/kotlin")
    }
}

tasks.register<Jar>("uberJar") {
   // zip64=true

    archiveClassifier.set("uber")
    from(sourceSets.main.get().output)
    dependsOn(configurations.runtimeClasspath)
    duplicatesStrategy = DuplicatesStrategy.WARN
    from( {
        configurations.runtimeClasspath.get().map{ zipTree(it)
               }
    })

    manifest {
        attributes["Class-Path"] = allClassPath.trim()
        attributes["Main-Class"] = "org.jetbrains.kotlinx.ki.shell.KotlinShell"
    }

}

var libpathfiles= StringBuilder();
File("./lib").walk().forEach { e ->
      if (e.toString().trim().endsWith(".jar"))
        libpathfiles.append(e.toString().replaceFirst("./", "").trim()).append(" ")

}

    var kotlinlibpathfiles= StringBuilder();
    File("./libkotlin").walk().forEach {
            e-> if (e.toString().trim().endsWith(".jar"))
        kotlinlibpathfiles.append(e.toString().replaceFirst("./","").trim()).append(" ")

    }



    var allClassPath = kotlinlibpathfiles.toString().trim()+" "+libpathfiles.toString().trim()





tasks.jar {
    baseName = "kotlinLab"

    manifest {
            attributes["Class-Path"] = allClassPath.trim()
            attributes["Main-Class"] = "org.jetbrains.kotlinx.ki.shell.KotlinShell"
    }

}


    
 
