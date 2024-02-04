package kr.co.title.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class User {
    @GetMapping("/v1/user")
    fun getUser(): Int {
        return 1
    }
}