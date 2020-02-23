package eu.gitcode.github_repositories.presentation.di

import dagger.Component
import eu.gitcode.core.di.scope.FeatureScope
import eu.gitcode.github_repositories.data.di.GithubReposModule
import eu.gitcode.network.NetworkComponent
import eu.gitcode.songs.presentation.di.GithubReposViewModel

@FeatureScope
@Component(
    modules = [
        GithubReposModule::class,
        GithubReposViewModel::class
    ], dependencies = [NetworkComponent::class]
)

interface GithubReposComponent {

    //  fun inject(fragment: GithubReposFragment)
}