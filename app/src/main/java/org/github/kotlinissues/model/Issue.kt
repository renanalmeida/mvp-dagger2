package org.github.kotlinissues.model

import com.google.gson.annotations.SerializedName

data class Issue(
    val title: String,
    val description: String,
    @SerializedName("created_at") val createDate: String,
    val user: User,
    val url: String,
    val state: String
)
