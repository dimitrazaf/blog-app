package com.dz.playground.user

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<PersistedUser, Long> {

    @Query("SELECT * FROM blog_app.users WHERE user_name = :username")
    fun findUserByUserId(@Param("username") username: String): PersistedUser?
}
