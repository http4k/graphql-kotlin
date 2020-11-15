description = "An Example GraphQL service served by a http4k server"

plugins {
    id("application")
}

application {
    mainClassName = "com.expediagroup.graphql.examples.http4k.ApplicationKt"
}

val http4kVersion: String by project

dependencies {
    implementation(platform("org.http4k:http4k-bom:$http4kVersion"))
    implementation("org.http4k:http4k-core")
    implementation("org.http4k:http4k-graphql")
    implementation("com.expediagroup", "graphql-kotlin-schema-generator")
}
