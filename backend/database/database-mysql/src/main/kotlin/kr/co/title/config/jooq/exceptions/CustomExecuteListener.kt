package kr.co.title.config.jooq.exceptions

import mu.KotlinLogging
import org.jooq.ExecuteContext
import org.jooq.ExecuteListener
import org.jooq.SQLDialect
import org.jooq.tools.StopWatch
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator
import org.springframework.jdbc.support.SQLExceptionTranslator

class CustomExecuteListener: ExecuteListener {
    lateinit var watch: StopWatch

    override fun exception(context: ExecuteContext) {
        val dialect: SQLDialect = context.configuration().dialect()
        val translator: SQLExceptionTranslator = SQLErrorCodeSQLExceptionTranslator(dialect.name)

        context.exception(translator.translate("Jooq Connection Error", context.sql(), context.sqlException()!!))
    }

    override fun executeStart(ctx: ExecuteContext?) {
        super.executeStart(ctx)
        watch = StopWatch()
    }

    override fun executeEnd(ctx: ExecuteContext?) {
        super.executeEnd(ctx)
        if (watch.split() > 5_000_000_000L)
            if (ctx != null) {
                logger.warn("Slow Query Detected: ${ctx.query()}", Exception())
            };
    }

    companion object {
        private val logger = KotlinLogging.logger {}
    }
}