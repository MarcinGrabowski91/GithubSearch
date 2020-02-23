package eu.gitcode.login.domain.repository

import eu.gitcode.login.domain.model.GithubRepo
import io.reactivex.Single

interface ReposRepository {
    fun getRepos(): Single<List<GithubRepo>>

    fun getRepoInfo(ownerName: String, repoName: String): Single<GithubRepo>
}