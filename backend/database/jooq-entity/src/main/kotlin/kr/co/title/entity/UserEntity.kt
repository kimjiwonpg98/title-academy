package kr.co.title.entity

import jakarta.persistence.*
import kr.co.title.entity.UserEntity.Companion.USER_REPOSITORY_NAME
import kr.co.title.entity.common.CommonEntity

@Entity
@Table(name = USER_REPOSITORY_NAME)
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BIGINT")
    val id: Long?,

    @Column(name = "email", length =  40, nullable = true)
    val email: String? = null,

    @Column(name = "nickname", length =  40, nullable = false)
    val nickname: String,

): CommonEntity() {
    companion object {
        const val USER_REPOSITORY_NAME = "user"
    }
}