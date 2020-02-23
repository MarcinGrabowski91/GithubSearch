package eu.gitcode.github_repositories.domain.usecase

import eu.gitcode.github_repositories.domain.model.GithubRepo
import eu.gitcode.github_repositories.domain.repository.GithubReposRepository
import io.reactivex.Single

class GetRepoInfoUseCase(private val githubReposRepository: GithubReposRepository) {
    fun getRepoInfo(repoName: String, ownerName: String): Single<GithubRepo> {
        return githubReposRepository.getRepoInfo(repoName, ownerName)
    }
}