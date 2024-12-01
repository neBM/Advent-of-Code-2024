plugins {
    id("buildsrc.convention.kotlin-jvm")
    application
}

dependencies {
    implementation(project(":utils"))
    implementation(project.libs.kotlinxDataFrame)
    testImplementation(kotlin("test"))
    testImplementation(project.libs.kotest)
}

application {
    mainClass = "uk.co.brmartin.adventofcode2024.app.AppKt"
}
