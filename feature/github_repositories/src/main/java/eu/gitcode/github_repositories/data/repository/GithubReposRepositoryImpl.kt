package eu.gitcode.github_repositories.data.repository

import eu.gitcode.github_repositories.data.service.GithubReposService
import eu.gitcode.github_repositories.domain.model.GithubRepo
import eu.gitcode.github_repositories.domain.repository.ReposRepository
import io.reactivex.Single

class GithubReposRepositoryImpl(private val githubReposService: GithubReposService) :
    ReposRepository {

    override fun getRepos(): Single<List<GithubRepo>> {
        return githubReposService.getBestRepos()
            .map { repos -> repos.toGithubRepoDomainList() }
    }

    override fun getRepoInfo(ownerName: String, repoName: String): Single<GithubRepo> {
        return githubReposService.getRepoInfo(ownerName, repoName)
            .map { repo -> repo.toDomainModel() }
    }
}