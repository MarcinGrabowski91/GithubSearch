package eu.gitcode.github_repositories.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import eu.gitcode.github_repositories.domain.usecase.GetReposListUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class GithubReposViewModel
@Inject constructor(private val getReposListUseCase: GetReposListUseCase) : ViewModel() {

    private val _state: MutableLiveData<GithubReposViewState> by lazy {
        MutableLiveData<GithubReposViewState>(
            GithubReposViewState(listState = GithubReposListState.Loading)
        )
    }
    private var githubReposDisposable: Disposable? = null

    val state: LiveData<GithubReposViewState>
        get() = _state

    fun getSongs() {
        githubReposDisposable?.dispose()
        githubReposDisposable = getReposListUseCase.getReposList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                _state.value = _state.value?.copy(listState = GithubReposListState.Loading)
            }
            .subscribeBy(
                onSuccess = {
                    _state.value = _state.value?.copy(
                        githubReposList = it,
                        listState = if (it.isEmpty()) GithubReposListState.Empty else GithubReposListState.Listed
                    )
                },
                onError = {
                    Timber.e(it)
                    _state.value = _state.value?.copy(
                        githubReposList = listOf(),
                        listState = GithubReposListState.Error
                    )
                })
    }

    override fun onCleared() {
        githubReposDisposable?.dispose()
        super.onCleared()
    }
}