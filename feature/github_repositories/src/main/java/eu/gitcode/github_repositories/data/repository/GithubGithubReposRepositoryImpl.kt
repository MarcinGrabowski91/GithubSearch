package eu.gitcode.github_repositories.data.repository

import eu.gitcode.github_repositories.data.db.OwnerDao
import eu.gitcode.github_repositories.data.db.RepoDao
import eu.gitcode.github_repositories.data.service.GithubReposService
import eu.gitcode.github_repositories.domain.model.GithubRepo
import eu.gitcode.github_repositories.domain.repository.GithubReposRepository
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class GithubGithubReposRepositoryImpl(
    private val githubReposService: GithubReposService,
    private val repoDao: RepoDao,
    private val ownerDao: OwnerDao
) :
    GithubReposRepository {

    override fun getRepos(keyword: String): Observable<List<GithubRepo>> {
        return githubReposService.getBestRepos(keyword)
            .flatMapObservable {
                Observable.fromCallable { it }.map { repos -> repos.toEntitiesPair() }
                    .map { pair ->
                        repoDao.insertRepo(pair.first)
                        ownerDao.insertOwner(pair.second)
                    }.subscribeOn(Schedulers.io()).subscribe()
                Observable.just(it)
            }
            .map { repos -> repos.toGithubRepoDomainList() }
            .onErrorReturnItem(
                getReposByStars()
            )

    }

    override fun getRepoInfo(ownerName: String, repoName: String): Single<GithubRepo> {
        return githubReposService.getRepoInfo(ownerName, repoName)
            .map { repo -> repo.toDomainModel() }
    }

    private fun getReposByStars(): List<GithubRepo> {
        val repos = mutableListOf<GithubRepo>()
        repoDao.getReposByStars()
            .asSequence()
            .iterator()
            .forEach { repo ->
                val owner = ownerDao.getOwner(repo.ownerId)
                repos.add(repo.toDomainModel(owner))
            }
        return repos
    }
}

