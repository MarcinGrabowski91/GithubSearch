package eu.gitcode.github_repositories.presentation.di

import android.app.Application
import dagger.Component
import eu.gitcode.core.di.scope.FeatureScope
import eu.gitcode.github_repositories.data.di.GithubReposModule
import eu.gitcode.github_repositories.data.di.PersistenceModule
import eu.gitcode.github_repositories.presentation.detail.GithubRepoDetailFragment
import eu.gitcode.github_repositories.presentation.list.GithubReposFragment
import eu.gitcode.network.NetworkComponent

@FeatureScope
@Component(
    modules = [
        GithubReposModule::class,
        GithubReposViewModelModule::class,
        PersistenceModule::class
    ], dependencies = [NetworkComponent::class]
)

interface GithubReposComponent {

    fun inject(application: Application)

    fun inject(fragment: GithubReposFragment)

    fun inject(fragment: GithubRepoDetailFragment)
}