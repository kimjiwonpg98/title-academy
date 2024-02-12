package kr.co.title.config.jooq

import kr.co.title.config.jooq.enums.TextSearchWildcard
import kr.co.title.config.jooq.enums.TextSearchWildcard.*
import org.jooq.TableField
import org.jooq.impl.DSL
import org.jooq.*
import org.jooq.tools.StringUtils
import org.springframework.util.CollectionUtils



interface BaseJooqRepository {
    fun inIfNotEmpty(columnVal: TableField<Record?, Int?>, paramVal: List<Int?>?): Condition? {
        if (CollectionUtils.isEmpty(paramVal)) {
            return DSL.noCondition()
        }
        return columnVal.`in`(paramVal)
    }

    fun likeIfNotEmpty(
        column: TableField<out Record?, String?>,
        searchInput: String,
        searchWildcard: TextSearchWildcard?
    ): Condition? {
        if (StringUtils.isBlank(searchInput)) {
            return DSL.noCondition()
        }

        return when (searchWildcard) {
            FULL_TEXT -> column.like("%$searchInput%")
            PREFIX -> column.like("%$searchInput")
            SUFFIX -> column.like("$searchInput%")
            NONE -> column.eq(searchInput)
            null -> DSL.noCondition()
        }
    }

    fun likeIfNotEmpty(column: TableField<out Record?, String?>, searchInput: String): Condition? =
        likeIfNotEmpty(column, searchInput, NONE)

}