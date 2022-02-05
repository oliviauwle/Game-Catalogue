package com.example.gamecatalogue.network.response


import com.google.gson.annotations.SerializedName

data class LatestResponse(
    @SerializedName("results")
    val results: List<LatestItem>?
)