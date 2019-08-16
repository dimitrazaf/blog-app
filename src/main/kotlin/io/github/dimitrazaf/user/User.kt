package io.github.dimitrazaf.user

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import javax.persistence.Entity
import javax.validation.constraints.NotNull

@Table("blog_app.users")
data class PersistedUser(@Id val id: Long? = null,
                         val userName: String,
                         val password: String,
                         val email: String
)

@Entity
data class User(@NotNull val userName: String,
                @NotNull val password: String,
                @NotNull val email: String) {

    fun toPersistedUser(): PersistedUser {
        return PersistedUser(userName = userName, password = password, email = email)
    }
}