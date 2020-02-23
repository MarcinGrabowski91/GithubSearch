package eu.gitcode.navigation

import android.content.Context
import android.content.Intent

object Navigation {
    fun openGithubReposIntent(context: Context) =
        Intent("action.github_repositories.open").setPackage(context.packageName)
}
