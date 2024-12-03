plugins {
    id("buildsrc.convention.kotlin-jvm")
    application
}

dependencies {
    implementation(project(":utils"))
    implementation(libs.kotlinxDataFrame)
    testImplementation(kotlin("test"))
    testImplementation(libs.kotest)
}

application {
    mainClass = "uk.co.brmartin.adventofcode2024.app.Day2Kt"
}
