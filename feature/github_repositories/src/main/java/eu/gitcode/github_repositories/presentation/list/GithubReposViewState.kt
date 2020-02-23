package eu.gitcode.github_repositories.presentation.list

import eu.gitcode.github_repositories.domain.model.GithubRepo

data class GithubReposViewState(
    val githubReposList: List<GithubRepo> = listOf(),
    val listState: GithubReposListState = GithubReposListState.Loading
)
