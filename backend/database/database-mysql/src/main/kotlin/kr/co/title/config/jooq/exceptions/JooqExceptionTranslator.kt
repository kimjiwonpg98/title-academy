package kr.co.title.config.jooq.exceptions

import org.jooq.impl.DefaultExecuteListenerProvider

class JooqExceptionTranslator(listener: CustomExecuteListener) : DefaultExecuteListenerProvider(listener)