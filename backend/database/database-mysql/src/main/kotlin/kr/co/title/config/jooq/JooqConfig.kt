package kr.co.title.config.jooq

import kr.co.title.config.jooq.exceptions.CustomExecuteListener
import kr.co.title.config.jooq.exceptions.JooqExceptionTranslator
import org.jooq.SQLDialect
import org.jooq.impl.DataSourceConnectionProvider
import org.jooq.impl.DefaultConfiguration
import org.jooq.impl.DefaultDSLContext
import org.modelmapper.ModelMapper
import org.modelmapper.convention.NameTokenizers
import org.modelmapper.jooq.RecordValueReader
import org.modelmapper.module.jdk8.Jdk8Module
import org.modelmapper.module.jsr310.Jsr310Module
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy


@Configuration
class JooqConfig (
    private val transactionAwareDataSource: TransactionAwareDataSourceProxy? = null
) {
    @Bean
    fun dslContext(configuration: org.jooq.Configuration?): DefaultDSLContext {
        return DefaultDSLContext(configuration)
    }

    @Bean
    fun modelMapper(): ModelMapper {
        val mapper = ModelMapper()
        mapper.registerModule(Jsr310Module())
        mapper.registerModule(Jdk8Module())
        mapper.configuration
            .setSourceNameTokenizer(NameTokenizers.UNDERSCORE)
            .addValueReader(RecordValueReader())

        return mapper
    }

    @Bean
    fun connectionProvider(): DataSourceConnectionProvider {
        return DataSourceConnectionProvider(transactionAwareDataSource)
    }

    @Bean
    fun exceptionTransformer(): JooqExceptionTranslator {
        return JooqExceptionTranslator(CustomExecuteListener())
    }

    @Bean
    fun dsl(): DefaultDSLContext {
        return DefaultDSLContext(configuration())
    }

    @Bean
    fun configuration(): DefaultConfiguration {
        val jooqConfiguration = DefaultConfiguration()
        jooqConfiguration.set(connectionProvider())
        jooqConfiguration.set(exceptionTransformer())

        jooqConfiguration.set(SQLDialect.MYSQL)
        return jooqConfiguration
    }
}


