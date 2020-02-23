package eu.gitcode.login.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReposSummaryData(
    @Json(name = "incomplete_results")
    val incompleteResults: Boolean,
    @Json(name = "items")
    val items: List<RepoData>,
    @Json(name = "total_count")
    val totalCount: Int
)