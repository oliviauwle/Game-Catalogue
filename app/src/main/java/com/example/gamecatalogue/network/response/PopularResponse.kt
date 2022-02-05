package com.example.gamecatalogue.response


import com.google.gson.annotations.SerializedName
import com.example.gamecatalogue.network.response.PopularItem

data class PopularResponse(
    @SerializedName("results")
    val results: List<PopularItem?>
)