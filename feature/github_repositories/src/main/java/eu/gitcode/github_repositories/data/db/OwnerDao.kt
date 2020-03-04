package eu.gitcode.github_repositories.data.db

import androidx.room.*
import eu.gitcode.github_repositories.data.model.OwnerEntity
import io.reactivex.Completable

@Dao
interface OwnerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOwner(owners: List<OwnerEntity>): Completable

    @Update
    fun updateOwner(owner: OwnerEntity)

    @Query("SELECT * FROM OwnerEntity WHERE id = :id_")
    fun getOwner(id_: Int): OwnerEntity

    @Query("SELECT * FROM OwnerEntity")
    fun getOwners(): OwnerEntity
}
