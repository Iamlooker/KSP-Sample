plugins {
    kotlin("jvm")
    id("com.google.devtools.ksp")
    application
}

group = "com.looker"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":annotations"))
    ksp(project(":processor"))
    // Because KSP doesn't support sourceSet based code-generation
    implementation(kotlin("test"))
    testImplementation(kotlin("reflect"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}