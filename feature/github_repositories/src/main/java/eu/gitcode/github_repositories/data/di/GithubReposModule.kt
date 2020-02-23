package eu.gitcode.github_repositories.data.di

import dagger.Module
import dagger.Provides
import eu.gitcode.core.di.scope.FeatureScope
import eu.gitcode.github_repositories.data.repository.GithubGithubReposRepositoryImpl
import eu.gitcode.github_repositories.data.service.GithubReposService
import eu.gitcode.github_repositories.domain.repository.GithubReposRepository
import retrofit2.Retrofit

@Module
class GithubReposModule {

    @FeatureScope
    @Provides
    fun provideSongsApi(
        retrofit: Retrofit
    ): GithubReposService = retrofit.create(GithubReposService::class.java)

    @FeatureScope
    @Provides
    fun provideGithubReposRepository(
        githubReposService: GithubReposService
    ): GithubReposRepository = GithubGithubReposRepositoryImpl(githubReposService)
}