package org.github.kotlinissues.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Issue(
    val title: String,
    @SerializedName("body") val description: String?,
    @SerializedName("created_at") val createDate: String,
    val user: User,
    @SerializedName("html_url") val url: String,
    val state: String
):Parcelable
