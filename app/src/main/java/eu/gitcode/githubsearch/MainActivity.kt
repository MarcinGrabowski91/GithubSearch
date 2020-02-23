package eu.gitcode.githubsearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eu.gitcode.navigation.Navigation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Navigation.openGithubReposIntent(this))
    }
}