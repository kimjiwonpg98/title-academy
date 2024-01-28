package kr.co.title.user.infrastucture

import kr.co.title.user.domain.User

interface UserRepository {
    fun readByUserId(id: String): User
}