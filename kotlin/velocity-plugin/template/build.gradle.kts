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
    }

    build {
        dependsOn(shadowJar)
    }

    withType<JavaCompile> {
        options.compilerArgs.add("-Xlint:deprecation")
    }

    val sourcesJar by registering(Jar::class) {
        archiveBaseName.set("${rootProject.name}")
        archiveClassifier.set("sources")
        from(sourceSets.main.get().allSource)
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            groupId = project.group.toString()
            artifactId = "${rootProject.name}"
            version = project.version.toString()

            artifact(tasks.named("sourcesJar"))
        }
    }
    repositories {
        maven {
            url = rootProject.layout.buildDirectory.dir("repo").get().asFile.toURI()
        }
    }
}
