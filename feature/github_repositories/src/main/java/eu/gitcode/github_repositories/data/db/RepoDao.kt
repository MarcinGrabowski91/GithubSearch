package eu.gitcode.github_repositories.data.db

import androidx.room.*
import eu.gitcode.github_repositories.data.model.GithubRepoEntity
import io.reactivex.Completable

@Dao
interface RepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepo(tvs: List<GithubRepoEntity>): Completable

    @Update
    fun updateRepo(tv: GithubRepoEntity)

    @Query("SELECT * FROM Repos WHERE id = :id_")
    fun getRepo(id_: Int): GithubRepoEntity

    @Query("SELECT * FROM Repos ORDER BY stars")
    fun getReposByStars(): List<GithubRepoEntity>
}
