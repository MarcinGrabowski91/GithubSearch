package eu.gitcode.network

import com.squareup.moshi.Moshi
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class
    ]
)
interface NetworkComponent {

    fun retrofit(): Retrofit

    fun moshi(): Moshi
}