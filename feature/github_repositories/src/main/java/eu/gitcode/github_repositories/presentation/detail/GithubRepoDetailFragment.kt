package eu.gitcode.github_repositories.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import eu.gitcode.core.extension.visible
import eu.gitcode.github_repositories.databinding.RepoDetailFragmentBinding
import eu.gitcode.github_repositories.presentation.di.DaggerGithubReposComponent
import eu.gitcode.network.DaggerNetworkComponent
import javax.inject.Inject

class GithubRepoDetailFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: GithubRepoDetailViewModel

    private lateinit var binding: RepoDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        inject()
        binding = RepoDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        handleStates()
        viewModel.getReposList("a", "b")
    }

    private fun handleStates() {
        viewModel =
            ViewModelProvider(this, viewModelFactory).get(GithubRepoDetailViewModel::class.java)
        viewModel.state.observe(viewLifecycleOwner, Observer { state ->
            binding.repoNameTxt.text = state.githubRepo?.name
            binding.ownerNameTxt.text = state.githubRepo?.ownerData?.login
            binding.detailsGroup.visible = !state.detailsState.isError()
            binding.progressBar.visible = state.detailsState.isLoading()
            //            binding.emptyTxt.visible = state.listState.isEmpty()
//            binding.songsRecyclerViews.visible = state.listState.isListed()
//            binding.errorTxt.visible = state.listState.isError()
//            binding.spinner.visible = state.listState.isLoading()
        })
    }

    private fun inject() {
        val networkComponent = DaggerNetworkComponent
            .builder()
            .build()
        DaggerGithubReposComponent.builder()
            .networkComponent(networkComponent)
            .build()
            .inject(this)
    }

    companion object {
        private const val REPO_OWNER_KEY = "repo_owner"
        private const val REPO_NAME_KEY = "repo_key"

        fun newInstance(ownerName: String, repoName: String): GithubRepoDetailFragment {
            return GithubRepoDetailFragment().apply {
                Bundle().apply {
                    putString(REPO_OWNER_KEY, ownerName)
                    putString(REPO_NAME_KEY, repoName)
                }
            }
        }
    }
}
