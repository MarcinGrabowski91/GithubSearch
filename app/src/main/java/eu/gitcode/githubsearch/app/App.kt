package eu.gitcode.githubsearch.app

import android.app.Application
import eu.gitcode.githubsearch.BuildConfig
import io.reactivex.plugins.RxJavaPlugins
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        RxJavaPlugins.setErrorHandler(RxJavaErrorHandler())
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}