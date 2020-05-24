package com.dz.playground.user

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import javax.persistence.Entity

@Table("blog_app.users")
data class PersistedUser(
    @Id val id: Long? = null,
    val userName: String,
    val password: String,
    val email: String
)

@Entity
data class User(
    val userName: String? = null,
    val password: String? = null,
    val email: String? = null
) {
    
    fun toPersistedUser(): PersistedUser {
        return PersistedUser(
            userName = userName!!,
            password = password!!,
            email = email!!
        )
    }
}
