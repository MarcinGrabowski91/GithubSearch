package eu.gitcode.github_repositories.domain.usecase

import eu.gitcode.github_repositories.domain.model.GithubRepo
import eu.gitcode.github_repositories.domain.repository.ReposRepository
import io.reactivex.Single

class GetRepoInfoUseCase(private val reposRepository: ReposRepository) {
    fun getRepoInfo(repoName: String, ownerName: String): Single<GithubRepo> {
        return reposRepository.getRepoInfo(repoName, ownerName)
    }
}