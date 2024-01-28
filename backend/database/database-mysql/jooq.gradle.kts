jooq {
    configuration {
        generator {
            database {
                name = "org.jooq.meta.extensions.jpa.JPADatabase"
                inputSchema = "title_academy"
                properties {
                    property {
                        key = "packages"
                        value = "kr.co.title.entity"
                    }

                    property {
                        key = "useAttributeConverters"
                        value = true
                    }

                    property {
                        key = "hibernate.physical_naming_strategy"
                        value = "kr.co.title.naming.QuotedPhysicalNamingStrategy"
                    }
                }
            }
        }
        generate {
            deprecated = false
            record = true
            immutablePojos = true
            fluentSetters  = true
            javaTimeTypes = true
        }

        target {
            packageName = "jooq.jooq_dsl"
            directory = "src/generated"
            encoding = "UTF-8mb4"
        }
    }
}