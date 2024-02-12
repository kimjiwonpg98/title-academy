package kr.co.title.user

import kr.co.title.entity.UserEntity
import org.springframework.stereotype.Repository

@Repository
interface UserJpaRepository: UserEntityRepository<UserEntity, Long> {
    override fun save(entity: UserEntity): UserEntity

}