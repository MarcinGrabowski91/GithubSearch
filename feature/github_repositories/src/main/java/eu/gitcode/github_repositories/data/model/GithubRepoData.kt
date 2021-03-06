package eu.gitcode.github_repositories.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import eu.gitcode.github_repositories.domain.model.GithubRepo

@JsonClass(generateAdapter = true)
data class GithubRepoData(
    @Json(name = "created_at")
    val createdAt: String,
    @Json(name = "git_url")
    val gitUrl: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "owner")
    val ownerData: OwnerData,
    @Json(name = "stargazers_count")
    val stars: Int,
    @Json(name = "url")
    val url: String
) {
    fun toDomainModel(): GithubRepo {
        return GithubRepo(
            createdAt,
            gitUrl,
            id,
            name,
            ownerData.toDomainModel(),
            stars,
            url
        )
    }

    fun toEntity(): GithubRepoEntity {
        return GithubRepoEntity(
            id,
            gitUrl,
            createdAt,
            name,
            ownerData.id,
            stars,
            url
        )
    }
}