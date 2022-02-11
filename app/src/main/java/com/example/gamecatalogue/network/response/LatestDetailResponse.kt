package com.example.gamecatalogue.network.response


import com.google.gson.annotations.SerializedName

data class LatestDetailResponse(
    @field:SerializedName("background_image")
    val backgroundimage: String?,
    @field:SerializedName("id")
    val id: Int?,
    @field:SerializedName("name")
    val name: String?,
    @field:SerializedName("released")
    val released: String?,
    @field:SerializedName("description")
    val description: String?
)