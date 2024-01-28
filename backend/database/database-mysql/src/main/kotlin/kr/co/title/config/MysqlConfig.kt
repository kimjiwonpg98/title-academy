package kr.co.title.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackages = ["kr.co.title"])
@EntityScan(basePackages = ["kr.co.title.entity"])
@ComponentScan(basePackages = ["kr.co.title"])
class MysqlConfig
