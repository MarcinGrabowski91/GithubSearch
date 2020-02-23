package eu.gitcode.github_repositories.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eu.gitcode.github_repositories.databinding.RepoViewHolderBinding
import eu.gitcode.github_repositories.domain.model.GithubRepo

class GithubRepoAdapter(
    private val songs: MutableList<GithubRepo> = mutableListOf()
) : RecyclerView.Adapter<GithubRepoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val repoViewHolderBinding = RepoViewHolderBinding.inflate(inflater, parent, false)
        return ViewHolder(repoViewHolderBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = songs[position]

    }

    override fun getItemCount(): Int = songs.size

    fun setData(songs: List<GithubRepo>) {
        this.songs.clear()
        this.songs.addAll(songs)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: RepoViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root)
}