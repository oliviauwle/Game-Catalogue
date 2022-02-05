package com.example.gamecatalogue.network.response


import com.google.gson.annotations.SerializedName

data class PopularDetailResponse(
    @SerializedName("background_image")
    val backgroundimage: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("developer")
    val developer: String?,
    @SerializedName("overview")
    val overview: String?
)