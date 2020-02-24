package eu.gitcode.github_repositories.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import eu.gitcode.core.extension.visible
import eu.gitcode.github_repositories.databinding.ReposFragmentBinding
import eu.gitcode.github_repositories.presentation.di.DaggerGithubReposComponent
import eu.gitcode.network.DaggerNetworkComponent
import javax.inject.Inject

class GithubReposFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: GithubReposViewModel

    private lateinit var binding: ReposFragmentBinding

    private var adapter: GithubRepoAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        inject()
        binding = ReposFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        handleStates()
    }

    private fun handleStates() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(GithubReposViewModel::class.java)
        viewModel.state.observe(viewLifecycleOwner, Observer { state ->
            adapter?.setData(state.githubReposList)
            binding.emptyTxt.visible = state.listState.isEmpty()
            binding.songsRecyclerViews.visible =
                state.listState.isListed() || state.listState.isLoading()
            binding.errorTxt.visible = state.listState.isError()
            binding.spinner.visible = state.listState.isLoading()
        })
    }

    private fun setupRecyclerView() {
        binding.songsRecyclerViews.adapter = GithubRepoAdapter()
        binding.songsRecyclerViews.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                VERTICAL
            )
        )
        adapter = binding.songsRecyclerViews.adapter as GithubRepoAdapter
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
}
