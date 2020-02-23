package eu.gitcode.login.domain.usecase

import eu.gitcode.login.domain.model.GithubRepo
import eu.gitcode.login.domain.repository.ReposRepository
import io.reactivex.Single

class GetRepoInfoUseCase(private val reposRepository: ReposRepository) {
    fun getRepoInfo(repoName: String, ownerName: String): Single<GithubRepo> {
        return reposRepository.getRepoInfo(repoName, ownerName)
    }
}