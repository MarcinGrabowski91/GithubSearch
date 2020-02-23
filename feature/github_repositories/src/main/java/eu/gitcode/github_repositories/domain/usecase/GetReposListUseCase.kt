package eu.gitcode.github_repositories.domain.usecase

import eu.gitcode.github_repositories.domain.model.GithubRepo
import eu.gitcode.github_repositories.domain.repository.ReposRepository
import io.reactivex.Single

class GetReposListUseCase(private val repository: ReposRepository) {
    fun getReposList(): Single<List<GithubRepo>> {
        return repository.getRepos()
    }
}