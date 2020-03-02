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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ownerName = arguments?.getString(REPO_OWNER_KEY)
        val repoName = arguments?.getString(REPO_NAME_KEY)
        binding.ownerNameTxt.text = ownerName
        binding.repoNameTxt.text = repoName
        handleStates()
        arguments?.let {
            if (ownerName != null && repoName != null) {
                viewModel.getRepoDetails(ownerName, repoName)
            }
        }
    }

    private fun handleStates() {
        viewModel =
            ViewModelProvider(this, viewModelFactory).get(GithubRepoDetailViewModel::class.java)
        viewModel.state.observe(viewLifecycleOwner, Observer { state ->
            state.githubRepo?.name?.let {
                binding.repoNameTxt.text = it
            }
            state.githubRepo?.ownerData?.login?.let {
                binding.ownerNameTxt.text = it
            }
            binding.detailsGroup.visible = !state.detailsState.isError()
            binding.spinner.visible = state.detailsState.isLoading()
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
        const val REPO_OWNER_KEY = "repo_owner"
        const val REPO_NAME_KEY = "repo_key"
    }
}
