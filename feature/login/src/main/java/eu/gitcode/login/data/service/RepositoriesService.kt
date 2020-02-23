package eu.gitcode.login.data.service

import eu.gitcode.login.data.model.ReposSummaryData
import io.reactivex.Single
import retrofit2.http.POST
import retrofit2.http.Query

interface RepositoriesService {
    @POST("search/repositories")
    fun getBestRepos(
        @Query("q") keyword: String, @Query("page") page: Int,
        @Query("per_page") perPage: Int = DEFAULT_PAGE_SIZE,
        @Query("sort") sortType: String = "stars"
    ): Single<ReposSummaryData>

    companion object {
        private const val DEFAULT_PAGE_SIZE = 10
    }
}