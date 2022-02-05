package com.example.gamecatalogue.network.response


import com.google.gson.annotations.SerializedName

data class LatestItem(
    @SerializedName("background_image")
    val backgroundimage: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)