package eu.gitcode.github_repositories.data.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import eu.gitcode.github_repositories.data.db.OwnerDao
import eu.gitcode.github_repositories.data.db.RepoDao
import eu.gitcode.github_repositories.data.model.GithubRepoEntity
import eu.gitcode.github_repositories.data.model.OwnerEntity

@Database(
    entities = [GithubRepoEntity::class, OwnerEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun repoDao(): RepoDao

    abstract fun ownerDao(): OwnerDao
}
