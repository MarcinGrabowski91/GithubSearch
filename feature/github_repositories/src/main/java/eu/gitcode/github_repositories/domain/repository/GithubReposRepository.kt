package eu.gitcode.github_repositories.domain.repository

import eu.gitcode.github_repositories.domain.model.GithubRepo
import io.reactivex.Observable
import io.reactivex.Single

interface GithubReposRepository {
    fun getRepos(keyword: String): Observable<List<GithubRepo>>

    fun getRepoInfo(ownerName: String, repoName: String): Single<GithubRepo>
}