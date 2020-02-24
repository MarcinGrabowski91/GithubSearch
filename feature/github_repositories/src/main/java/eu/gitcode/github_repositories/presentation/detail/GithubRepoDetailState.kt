package eu.gitcode.github_repositories.presentation.detail

sealed class GithubRepoDetailState {

    object Loaded : GithubRepoDetailState()

    object Loading : GithubRepoDetailState()

    object Error : GithubRepoDetailState()

    fun isListed() = this is Loaded

    fun isLoading() = this is Loading

    fun isError() = this is Error
}