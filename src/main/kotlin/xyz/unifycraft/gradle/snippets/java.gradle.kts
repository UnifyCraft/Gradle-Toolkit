package xyz.unifycraft.gradle.snippets

import org.gradle.api.tasks.compile.JavaCompile
import xyz.unifycraft.gradle.MCData

plugins {
    java
}

val mcData = MCData.fromExisting(project)

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

extensions.configure<JavaPluginExtension> {
    toolchain.languageVersion.set(JavaLanguageVersion.of(mcData.javaVersion.majorVersion))
}
