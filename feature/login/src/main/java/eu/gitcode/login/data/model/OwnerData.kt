package eu.gitcode.login.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import eu.gitcode.login.domain.model.Owner

@JsonClass(generateAdapter = true)
data class OwnerData(
    @Json(name = "id")
    val id: Int,
    @Json(name = "login")
    val login: String
) {
    fun toDomainModel(): Owner {
        return Owner(id, login)
    }
}