package eu.gitcode.github_repositories.domain.model

data class GithubRepo(
    val createdAt: String,
    val gitUrl: String,
    val id: Int,
    val name: String,
    val ownerData: Owner,
    val stars: Int,
    val url: String
)