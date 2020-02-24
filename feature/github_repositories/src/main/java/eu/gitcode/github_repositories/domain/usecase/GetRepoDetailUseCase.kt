package eu.gitcode.github_repositories.domain.usecase

import eu.gitcode.github_repositories.domain.model.GithubRepo
import eu.gitcode.github_repositories.domain.repository.GithubReposRepository
import io.reactivex.Single

class GetRepoDetailUseCase(private val githubReposRepository: GithubReposRepository) {
    fun getRepoInfo(ownerName: String, repoName: String): Single<GithubRepo> {
        return githubReposRepository.getRepoInfo(ownerName, repoName)
    }
}