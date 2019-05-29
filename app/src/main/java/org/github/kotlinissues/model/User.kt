package org.github.kotlinissues.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: Long,
    @SerializedName("avatar_url") val avatarUrl: String
) : Parcelable