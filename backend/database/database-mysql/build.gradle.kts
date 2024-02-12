plugins {
    kotlin("plugin.noarg")
    kotlin("plugin.jpa")
    id("org.jooq.jooq-codegen-gradle") version "3.19.3"
}

dependencies {
    implementation(project(":domain"))
    api(project(":database:jooq-entity"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.modelmapper.extensions:modelmapper-jooq:2.3.9")
    implementation("com.github.chhsiao90:modelmapper-module-java8-datatypes:1.2.1")
    implementation("com.github.chhsiao90:modelmapper-module-jsr310:1.2.1")

    runtimeOnly("com.mysql:mysql-connector-j")
}

/** Arg 에러 방지 **/
noArg {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}