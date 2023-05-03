pluginManagement {
    plugins {
        id("com.google.devtools.ksp") version "1.8.21-1.0.11"
        kotlin("jvm") version "1.8.21"
    }
    repositories {
        gradlePluginPortal()
        google()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "LeetCodeSolutions"

include(":annotations")
include(":processor")
include(":main")