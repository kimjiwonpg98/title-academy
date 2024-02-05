package kr.co.title.persitences

import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class UserJooqRepository {
    private var dsl: DSLContext? = null

    fun UserRepository(dsl: DSLContext?) {
        this.dsl = dsl
    }
}