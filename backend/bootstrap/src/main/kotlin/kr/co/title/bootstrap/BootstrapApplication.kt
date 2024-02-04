package kr.co.title.bootstrap

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication(
	scanBasePackages = ["kr.co.title"]
)
@Import(

)
class BootstrapApplication

fun main(args: Array<String>) {
	runApplication<BootstrapApplication>(*args)
}
