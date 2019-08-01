package io.github.dimitrazaf

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling


@EnableScheduling
@SpringBootApplication
open class Application {
    // You could add your beans here
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}