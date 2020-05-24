package com.dz.playground.user

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/user")
open class UserResource(private val userService: UserService) {

    @PostMapping(value = ["/add"])
    open fun addUser(@RequestBody user: User) {
        userService.addUser(user)
    }
}
