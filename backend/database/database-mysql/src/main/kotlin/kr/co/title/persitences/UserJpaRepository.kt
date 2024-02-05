package kr.co.title.persitences

import kr.co.title.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserJpaRepository: JpaRepository<UserEntity, Long> {

}