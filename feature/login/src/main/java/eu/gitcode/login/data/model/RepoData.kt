package eu.gitcode.login.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import eu.gitcode.login.domain.model.Repo

@JsonClass(generateAdapter = true)
data class RepoData(
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
    @Json(name = "score")
    val score: Double,
    @Json(name = "url")
    val url: String
) {
    fun toDomainModel(): Repo {
        return Repo(
            createdAt,
            gitUrl,
            id,
            name,
            ownerData.toDomainModel(),
            score,
            url
        )
    }
}