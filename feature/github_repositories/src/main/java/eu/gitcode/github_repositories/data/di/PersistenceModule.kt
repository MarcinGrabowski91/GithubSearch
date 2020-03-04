/*
 * The MIT License (MIT)
 *
 * Designed and developed by 2018 skydoves (Jaewoong Eum)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package eu.gitcode.github_repositories.data.di

import android.app.Application
import android.content.Context
import androidx.annotation.NonNull
import androidx.room.Room
import dagger.Module
import dagger.Provides
import eu.gitcode.core.di.scope.FeatureScope
import eu.gitcode.github_repositories.data.db.OwnerDao
import eu.gitcode.github_repositories.data.db.RepoDao
import eu.gitcode.github_repositories.data.repository.AppDatabase

@Module
class PersistenceModule {

    @FeatureScope
    @Provides
    fun provideContext(app: Application): Context = app.applicationContext

    @FeatureScope
    @Provides
    fun provideDatabase(@NonNull context: Context): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "Repos.db")
            .build()
    }

    @FeatureScope
    @Provides
    fun provideRepoDao(@NonNull database: AppDatabase): RepoDao {
        return database.repoDao()
    }

    @FeatureScope
    @Provides
    fun provideOwnerDao(@NonNull database: AppDatabase): OwnerDao {
        return database.ownerDao()
    }
}
