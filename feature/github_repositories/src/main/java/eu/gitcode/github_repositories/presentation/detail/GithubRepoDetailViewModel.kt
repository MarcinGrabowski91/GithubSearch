package eu.gitcode.github_repositories.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import eu.gitcode.github_repositories.domain.usecase.GetRepoDetailUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class GithubRepoDetailViewModel
@Inject constructor(private val getRepoDetailUseCase: GetRepoDetailUseCase) : ViewModel() {

    private val _state: MutableLiveData<GithubRepoDetailsViewState> by lazy {
        MutableLiveData<GithubRepoDetailsViewState>(
            GithubRepoDetailsViewState(detailsState = GithubRepoDetailState.Loading)
        )
    }
    private var githubReposDisposable: Disposable? = null

    val state: LiveData<GithubRepoDetailsViewState>
        get() = _state

    fun getReposList(ownerName: String, repoName: String) {
        githubReposDisposable?.dispose()
        githubReposDisposable = getRepoDetailUseCase.getRepoInfo(ownerName, repoName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                _state.value = _state.value?.copy(detailsState = GithubRepoDetailState.Loading)
            }
            .subscribeBy(
                onSuccess = {
                    _state.value = _state.value?.copy(
                        githubRepo = it,
                        detailsState = if (it == null) GithubRepoDetailState.Error else GithubRepoDetailState.Loaded
                    )
                },
                onError = {
                    Timber.e(it)
                    _state.value = _state.value?.copy(
                        detailsState = GithubRepoDetailState.Error
                    )
                })
    }

    override fun onCleared() {
        githubReposDisposable?.dispose()
        super.onCleared()
    }
}