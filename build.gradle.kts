plugins {
    kotlin("jvm") version "1.8.20"
}

group = "org.leonard"
version = "1.0.0"

repositories {
    mavenCentral()
}

@Suppress("SpellCheckingInspection")
dependencies {
    implementation("com.formdev:flatlaf:${findProperty("flatlaf.version")}")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}