package eu.gitcode.github_repositories.data.model

import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import eu.gitcode.github_repositories.domain.model.Owner

@JsonClass(generateAdapter = true)
data class OwnerData(
    @PrimaryKey
    val id: Int,
    @Json(name = "login")
    val login: String
) {
    fun toDomainModel(): Owner {
        return Owner(id, login)
    }

    fun toEntity(): OwnerEntity {
        return OwnerEntity(id, login)
    }
}