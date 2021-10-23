val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.serialization") version "1.5.31"
    id("com.github.johnrengelman.shadow")  version "7.0.0"
    id ("com.google.cloud.tools.appengine") version "2.4.2"

}

group = "com.tales"
version = "0.0.1"
application {
    mainClass.set("com.tales.ApplicationKt")
}

repositories {
    mavenCentral()
}

appengine {
    stage {
        setArtifact("build/libs/${project.name}-${project.version}-all.jar")
    }
    deploy {
        version = "GCLOUD_CONFIG"
        projectId = "GCLOUD_CONFIG"
    }
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-serialization:$ktor_version")
    implementation("io.insert-koin:koin-ktor:3.1.2")
    implementation("org.litote.kmongo:kmongo:4.3.0")

    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")
}
