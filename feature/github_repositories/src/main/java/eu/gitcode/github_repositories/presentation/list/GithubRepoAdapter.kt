package eu.gitcode.github_repositories.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eu.gitcode.github_repositories.databinding.RepoViewHolderBinding
import eu.gitcode.github_repositories.domain.model.GithubRepo

class GithubRepoAdapter(
    private val repos: MutableList<GithubRepo> = mutableListOf()
) : RecyclerView.Adapter<GithubRepoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val repoViewHolderBinding = RepoViewHolderBinding.inflate(inflater, parent, false)
        return ViewHolder(repoViewHolderBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = repos[position]
        holder.binding.ownerNameTxt.text = item.ownerData.login
        holder.binding.repoNameTxt.text = item.name
        holder.binding.starsAmountTxt.text = item.stars.toString()
    }

    override fun getItemCount(): Int = repos.size

    fun setData(songs: List<GithubRepo>) {
        this.repos.clear()
        this.repos.addAll(songs)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: RepoViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root)
}