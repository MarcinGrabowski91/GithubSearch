package eu.gitcode.login.domain.model

data class GithubRepo(
    val createdAt: String,
    val gitUrl: String,
    val id: Int,
    val name: String,
    val ownerData: Owner,
    val score: Double,
    val url: String
)