package eu.gitcode.github_repositories.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import eu.gitcode.github_repositories.domain.model.GithubRepo

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = OwnerEntity::class,
            parentColumns = ["id"],
            childColumns = ["ownerId"]
        )],
    tableName = "Repos"
)
data class GithubRepoEntity(
    @PrimaryKey
    val id: Int,
    val createdAt: String,
    val gitUrl: String,
    val name: String,
    val ownerId: Int,
    val stars: Int,
    val url: String
) {
    fun toDomainModel(ownerEntity: OwnerEntity): GithubRepo {
        return GithubRepo(
            createdAt,
            gitUrl,
            id,
            name,
            ownerEntity.toDomainModel(),
            stars,
            url
        )
    }
}
