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

    implementation("org.apache.logging.log4j:log4j-api:${findProperty("log4j2.version")}")
    implementation("org.apache.logging.log4j:log4j-core:${findProperty("log4j2.version")}")
    implementation("org.apache.logging.log4j:log4j-slf4j2-impl:${findProperty("log4j2.version")}")

    implementation("org.slf4j:slf4j-api:${findProperty("slf4j.version")}")

    implementation("com.fasterxml.jackson.core:jackson-databind:${findProperty("jackson.version")}")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:${findProperty("jackson.version")}")

    testImplementation(kotlin("test"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}