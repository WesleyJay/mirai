@file:Suppress("UNUSED_VARIABLE")

plugins {
    kotlin("jvm")
    java
}

description = "Binary and source compatibility validator for mirai-core and mirai-core-qqandroid"

repositories {
    mavenCentral()
    jcenter()
}

kotlin {
    sourceSets {
        all {
            languageSettings.enableLanguageFeature("InlineClasses")
            languageSettings.useExperimentalAnnotation("kotlin.Experimental")
        }

        main {
            dependencies {
                api(kotlin("stdlib"))
                runtimeOnly(project(":mirai-core-qqandroid"))
                compileOnly("net.mamoe:mirai-core-qqandroid-jvm:0.33.0")
                api(kotlinx("coroutines-core", Versions.Kotlin.coroutines))
            }
        }

        test {
            dependencies {
                api(kotlin("stdlib"))
                api(kotlin("test"))
                api(kotlin("test-junit"))
                runtimeOnly(project(":mirai-core-qqandroid"))
                compileOnly("net.mamoe:mirai-core-qqandroid-jvm:0.33.0")
                api(kotlinx("coroutines-core", Versions.Kotlin.coroutines))
            }
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}