package org.github.kotlinissues.model

import com.google.gson.annotations.SerializedName

data class User(
    val id: Long,
    @SerializedName("avatar_url") val avatarUrl: String
)