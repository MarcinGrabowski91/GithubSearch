package eu.gitcode.github_repositories.presentation.di

import dagger.Component
import eu.gitcode.core.di.scope.FeatureScope
import eu.gitcode.github_repositories.data.di.GithubReposModule
import eu.gitcode.github_repositories.presentation.list.GithubReposFragment
import eu.gitcode.network.NetworkComponent

@FeatureScope
@Component(
    modules = [
        GithubReposModule::class,
        GithubReposViewModelModule::class
    ], dependencies = [NetworkComponent::class]
)

interface GithubReposComponent {

    fun inject(fragment: GithubReposFragment)
}