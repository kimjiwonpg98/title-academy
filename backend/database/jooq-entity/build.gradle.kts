plugins {
    kotlin("plugin.noarg")
    kotlin("plugin.jpa")
    id("org.jooq.jooq-codegen-gradle") version "3.19.3"
}

dependencies {
    implementation(project(":domain"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
}

/** Arg 에러 방지 **/
noArg {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}