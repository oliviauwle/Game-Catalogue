package com.example.gamecatalogue.network.response


import com.google.gson.annotations.SerializedName

data class LatestResponse(
    @field:SerializedName("results")
    val results: List<LatestItem>?
)