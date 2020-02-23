package eu.gitcode.github_repositories.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import eu.gitcode.github_repositories.domain.model.GithubRepo

@JsonClass(generateAdapter = true)
data class GithubReposSummaryData(
    @Json(name = "incomplete_results")
    val incompleteResults: Boolean,
    @Json(name = "items")
    val items: List<GithubRepoData>,
    @Json(name = "total_count")
    val totalCount: Int
) {
    fun toGithubRepoDomainList(): List<GithubRepo> {
        return items
            .asSequence()
            .map { githubRepoData -> githubRepoData.toDomainModel() }
            .toList()
    }
}