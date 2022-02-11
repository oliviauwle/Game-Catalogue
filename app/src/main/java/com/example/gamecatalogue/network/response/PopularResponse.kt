package com.example.gamecatalogue.network.response


import com.google.gson.annotations.SerializedName

data class PopularResponse(
    @field:SerializedName("results")
    val results: List<PopularItem>?
)