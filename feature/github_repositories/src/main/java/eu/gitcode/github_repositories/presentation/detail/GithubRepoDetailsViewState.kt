package eu.gitcode.github_repositories.presentation.detail

import eu.gitcode.github_repositories.domain.model.GithubRepo

data class GithubRepoDetailsViewState(
    val githubRepo: GithubRepo? = null,
    val detailsState: GithubRepoDetailState = GithubRepoDetailState.Loading
)
