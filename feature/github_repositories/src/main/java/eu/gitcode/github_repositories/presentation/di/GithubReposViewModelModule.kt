package eu.gitcode.github_repositories.presentation.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import eu.gitcode.core.di.ViewModelFactory
import eu.gitcode.core.di.ViewModelKey
import eu.gitcode.github_repositories.presentation.detail.GithubRepoDetailViewModel
import eu.gitcode.github_repositories.presentation.list.GithubReposViewModel

@Module
abstract class GithubReposViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(GithubReposViewModel::class)
    abstract fun bindGithubReposViewModel(viewModel: GithubReposViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GithubRepoDetailViewModel::class)
    abstract fun bindGithubRepoDetailViewModel(viewModel: GithubRepoDetailViewModel): ViewModel
}