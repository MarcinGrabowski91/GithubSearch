package eu.gitcode.login.data.service

import eu.gitcode.login.data.model.GithubRepoData
import eu.gitcode.login.data.model.GithubReposSummaryData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RepositoriesService {
    @GET("search/repositories")
    fun getBestRepos(
        @Query("q") keyword: String = "stars>10", @Query("page") page: Int = 20,
        @Query("per_page") perPage: Int = DEFAULT_PAGE_SIZE,
        @Query("sort") sortType: String = "stars"
    ): Single<GithubReposSummaryData>

    @GET("repos/{ownerName}/{repoName}")
    fun getRepoInfo(
        @Path("ownerName") ownerName: String, @Path("repoName") repoName: String
    ): Single<GithubRepoData>

    companion object {
        private const val DEFAULT_PAGE_SIZE = 10
    }
}