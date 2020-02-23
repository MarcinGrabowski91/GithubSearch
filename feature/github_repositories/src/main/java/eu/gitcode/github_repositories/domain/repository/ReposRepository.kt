package eu.gitcode.github_repositories.domain.repository

import eu.gitcode.github_repositories.domain.model.GithubRepo
import io.reactivex.Single

interface ReposRepository {
    fun getRepos(): Single<List<GithubRepo>>

    fun getRepoInfo(ownerName: String, repoName: String): Single<GithubRepo>
}