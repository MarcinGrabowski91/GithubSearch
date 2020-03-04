package eu.gitcode.github_repositories.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import eu.gitcode.github_repositories.domain.model.Owner

@Entity
data class OwnerEntity(
    @PrimaryKey
    val id: Int,
    val login: String
) {
    fun toDomainModel(): Owner {
        return Owner(id, login)
    }
}