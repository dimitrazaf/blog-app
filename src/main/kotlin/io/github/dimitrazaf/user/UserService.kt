package io.github.dimitrazaf.user

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class UserService(private val userRepository: UserRepository) {
    val LOG = LoggerFactory.getLogger(UserService::class.java)

    @Transactional
    open fun addUser(user: User) {
        try {
            when {
                userRepository.findUserByUserId(user.userName) != null -> {
                    LOG.debug("User with userName = ${user.userName} already exists")
                }else -> {
                    val persistedUser = user.toPersistedUser()
                    userRepository.save(persistedUser)
                }
            }
        } catch (e: Exception) {
            LOG.error("FAIL to save user with username = ${user.userName}", e)
            throw RuntimeException(e)
        }
    }

}