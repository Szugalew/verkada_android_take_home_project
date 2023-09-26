package com.verkada.android.catpictures.data.model


import com.google.gson.annotations.SerializedName

data class Picture (
    @SerializedName("id")
    val id: String,
    @SerializedName("download_url")
    val url: String,
)
