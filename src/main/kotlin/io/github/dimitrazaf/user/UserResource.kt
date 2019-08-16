package io.github.dimitrazaf.user

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/v1/user")
open class UserResource(private val userService: UserService) {

    @PostMapping(value = ["add"])
    open fun addUser(@Valid user: User) {
        userService.addUser(user)
    }
}