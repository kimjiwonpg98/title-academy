package kr.co.title.user.domain

import kr.co.title.user.domain.vo.*

data class User (
    val id: UserId,
    val nickname: Nickname,
    val createdAt: CreatedAt,
    val updatedAt: UpdatedAt,
    val email: UserEmail
)