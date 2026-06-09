plugins {
    java
    `maven-publish`
    kotlin("jvm") version "2.4.0"
    kotlin("kapt") version "2.4.0"
    id("com.gradleup.shadow") version "9.4.2"
}

group = "dev.elysium.{{PROJECT_NAME_LOWERCASE}}"

version = "1.0.0"

repositories {
    mavenCentral()
    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    compileOnly("com.velocitypowered:velocity-api:3.5.0-SNAPSHOT")
    kapt("com.velocitypowered:velocity-api:3.5.0-SNAPSHOT")
}

val targetJavaVersion = 21
kotlin {
    jvmToolchain(targetJavaVersion)
}
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(targetJavaVersion))
}

tasks {
    shadowJar {
        archiveClassifier.set("") // Убирает суффикс "-all" из названия файла

        minimize {}
        
        relocate("kotlin", "dev.elysium.{{PROJECT_NAME_LOWERCASE}}.internal.kotlin")
        relocate("kotlinx", "dev.elysium.{{PROJECT_NAME_LOWERCASE}}.internal.kotlinx")
        relocate("org.intellij.lang.annotations", "dev.elysium.{{PROJECT_NAME_LOWERCASE}}.internal.org.intellij.lang.annotations")
        relocate("org.jetbrains.annotations", "dev.elysium.{{PROJECT_NAME_LOWERCASE}}.internal.org.jetbrains.annotations")
    }
    build {
        dependsOn(shadowJar)
    }
    withType<JavaCompile> {
        options.compilerArgs.add("-Xlint:deprecation")
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = project.group.toString()
            artifactId = "{{PROJECT_NAME}}"
            version = project.version.toString()
        }
    }
}
