package eu.gitcode.github_repositories.domain.usecase

import eu.gitcode.github_repositories.domain.model.GithubRepo
import eu.gitcode.github_repositories.domain.repository.GithubReposRepository
import io.reactivex.Observable

class GetReposListUseCase(private val repositoryGithub: GithubReposRepository) {
    fun getReposList(keyword: String): Observable<List<GithubRepo>> {
        return repositoryGithub.getRepos(keyword)
    }
}