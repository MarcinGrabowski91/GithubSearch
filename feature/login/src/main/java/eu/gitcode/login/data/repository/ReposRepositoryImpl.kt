package eu.gitcode.login.data.repository

import eu.gitcode.login.data.service.RepositoriesService
import eu.gitcode.login.domain.model.GithubRepo
import eu.gitcode.login.domain.repository.ReposRepository
import io.reactivex.Single

class ReposRepositoryImpl(private val repositoriesService: RepositoriesService) : ReposRepository {

    override fun getRepos(): Single<List<GithubRepo>> {
        return repositoriesService.getBestRepos()
            .map { repos -> repos.toGithubRepoDomainList() }
    }

    override fun getRepoInfo(ownerName: String, repoName: String): Single<GithubRepo> {
        return repositoriesService.getRepoInfo(ownerName, repoName)
            .map { repo -> repo.toDomainModel() }
    }
}