import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.4.10"
    id("net.fabricmc.fabric-loom") version "1.17-SNAPSHOT"
}

version = project.property("mod_version") as String
group = project.property("maven_group") as String

base {
    archivesName.set(project.property("archives_base_name") as String)
}

val targetJavaVersion = 25
java {
    toolchain.languageVersion = JavaLanguageVersion.of(targetJavaVersion)
    // Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task
    // if it is present.
    // If you remove this line, sources will not be generated.
    withSourcesJar()
}

fabricApi {
    configureDataGeneration {
        client = true

        // Only run minekea's own datagen entrypoint. Without this, the datagen entrypoints of the
        // localRuntime mods (BetterEnd, BetterNether, wover, ...) also run against the same output
        // directory and delete all of minekea's freshly generated files as "stale".
        modId = "minekea"
    }
}

sourceSets {
    main {
        resources {
            srcDirs.add(File("src/main/generated"))
        }
    }
}

repositories {
    maven {
        name = "CurseForge"
        url = uri("https://cursemaven.com")
    }
    maven {
        name = "Architectury"
        url = uri("https://maven.architectury.dev/")
    }
    maven {
        name = "Modrinth"
        url = uri("https://api.modrinth.com/maven")
    }
}

dependencies {
    // To change the versions see the gradle.properties file
    minecraft("com.mojang:minecraft:${project.property("minecraft_version")}")
    implementation("net.fabricmc:fabric-loader:${project.property("loader_version")}")
    implementation("net.fabricmc:fabric-language-kotlin:${project.property("kotlin_loader_version")}")

    implementation("net.fabricmc.fabric-api:fabric-api:${project.property("fabric_api_version")}")

    // Update version number from https://www.curseforge.com/minecraft/mc-mods/chimericlib
    implementation("curse.maven:chimericlib-1107232:8824300")
    implementation("dev.architectury:architectury-fabric:${project.property("architectury_api_version")}")

    // BetterEnd & BetterNether, version 26.201.2
    // Update version from https://modrinth.com/mod/betterend/versions & https://modrinth.com/mod/betternether/versions
    // compileOnly so the mods are never required at runtime for end users;
    // localRuntime so they are loaded in local dev runs (e.g. runDatagen) for loot tables & models
    compileOnly("maven.modrinth:gc8OEnCC:VD4qwVUF")
    localRuntime("maven.modrinth:gc8OEnCC:VD4qwVUF")
    compileOnly("maven.modrinth:MpzVLzy5:iBR9QMPF")
    localRuntime("maven.modrinth:MpzVLzy5:iBR9QMPF")

    // Runtime-only libraries required by BetterEnd & BetterNether in dev runs:
    // BCLib (https://modrinth.com/mod/bclib),
    // WorldWeaver (https://modrinth.com/mod/worldweaver)
    // and WunderLib (https://modrinth.com/mod/wunderlib)
    localRuntime("maven.modrinth:BgNRHReB:7BfGRji6")
    localRuntime("maven.modrinth:RiN8rDVs:GHdiOIsp")
    localRuntime("maven.modrinth:8O0Adq7w:x1Ln5h2L")
}
loom {
    accessWidenerPath.set(file("src/main/resources/minekea.accesswidener"))
}

tasks.processResources {
    inputs.property("version", project.version)
    inputs.property("minecraft_version", project.property("minecraft_version"))
    inputs.property("loader_version", project.property("loader_version"))
    filteringCharset = "UTF-8"

    filesMatching("fabric.mod.json") {
        expand(
            "version" to project.version,
            "minecraft_version" to project.property("minecraft_version") as String,
            "loader_version" to project.property("loader_version") as String,
            "kotlin_loader_version" to project.property("kotlin_loader_version") as String,
        )
    }
}

tasks.withType<JavaCompile>().configureEach {
    // ensure that the encoding is set to UTF-8, no matter what the system default is
    // this fixes some edge cases with special characters not displaying correctly
    // see http://yodaconditions.net/blog/fix-for-java-file-encoding-problems-with-gradle.html
    // If Javadoc is generated, this must be specified in that task too.
    options.encoding = "UTF-8"
    options.release.set(targetJavaVersion)
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions.jvmTarget.set(JvmTarget.fromTarget(targetJavaVersion.toString()))
}

tasks.jar {
    from("LICENSE") {
        rename { "${it}_${project.base.archivesName.get()}" }
    }
}
