buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.44")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
    }
    repositories {
        mavenCentral()
    }
}
plugins {
    kotlin("plugin.serialization") version "1.6.10"
    id("com.android.application") version "7.4.1"
    id("org.jetbrains.kotlin.android") version "1.7.0"
}

allprojects {
}