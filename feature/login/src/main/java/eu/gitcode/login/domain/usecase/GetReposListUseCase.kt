package eu.gitcode.login.domain.usecase

import eu.gitcode.login.domain.model.GithubRepo
import eu.gitcode.login.domain.repository.ReposRepository
import io.reactivex.Single

class GetReposListUseCase(private val repository: ReposRepository) {
    fun getReposList(): Single<List<GithubRepo>> {
        return repository.getRepos()
    }
}