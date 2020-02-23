package eu.gitcode.github_repositories.domain.usecase

import eu.gitcode.github_repositories.domain.model.GithubRepo
import eu.gitcode.github_repositories.domain.repository.GithubReposRepository
import io.reactivex.Single

class GetReposListUseCase(private val repositoryGithub: GithubReposRepository) {
    fun getReposList(keyword: String): Single<List<GithubRepo>> {
        return repositoryGithub.getRepos(keyword)
    }
}