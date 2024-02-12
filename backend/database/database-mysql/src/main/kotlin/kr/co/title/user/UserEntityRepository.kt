package kr.co.title.user

import kr.co.title.entity.UserEntity
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository

@NoRepositoryBean
interface UserEntityRepository<T, ID>: Repository<T, ID> {
    fun save(entity: UserEntity): UserEntity
}