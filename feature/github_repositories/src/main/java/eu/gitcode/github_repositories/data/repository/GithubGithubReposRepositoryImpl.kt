package eu.gitcode.github_repositories.data.repository

import eu.gitcode.github_repositories.data.service.GithubReposService
import eu.gitcode.github_repositories.domain.model.GithubRepo
import eu.gitcode.github_repositories.domain.repository.GithubReposRepository
import io.reactivex.Single

class GithubGithubReposRepositoryImpl(private val githubReposService: GithubReposService) :
    GithubReposRepository {

    override fun getRepos(keyword: String): Single<List<GithubRepo>> {
        return githubReposService.getBestRepos(keyword)
            .map { repos -> repos.toGithubRepoDomainList() }
    }

    override fun getRepoInfo(ownerName: String, repoName: String): Single<GithubRepo> {
        return githubReposService.getRepoInfo(ownerName, repoName)
            .map { repo -> repo.toDomainModel() }
    }
}