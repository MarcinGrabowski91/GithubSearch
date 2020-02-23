package eu.gitcode.github_repositories.presentation.list

sealed class GithubReposListState {

    object Empty : GithubReposListState()

    object Listed : GithubReposListState()

    object Loading : GithubReposListState()

    object Error : GithubReposListState()

    fun isEmpty() = this is Empty

    fun isListed() = this is Listed

    fun isLoading() = this is Loading

    fun isError() = this is Error
}