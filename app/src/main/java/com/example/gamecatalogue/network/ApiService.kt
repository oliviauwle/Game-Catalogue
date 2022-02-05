package com.example.gamecatalogue.network;

import com.example.gamecatalogue.network.response.LatestDetailResponse
import com.example.gamecatalogue.network.response.LatestResponse
import com.example.gamecatalogue.network.response.PopularDetailResponse
import com.example.gamecatalogue.response.PopularResponse
import com.example.gamecatalogue.utils.Const
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("games?api_key=${Const.apiKey}")
    fun getPopular(): Call<PopularResponse>

    @GET("games?api_key=${Const.apiKey}&ordering=-released")
    fun getLatest(): Call<LatestResponse>

    @GET("games??api_key=${Const.apiKey}")
    fun getPopularDetail(@Path("id") id: Int): Call<PopularDetailResponse>

    @GET("games?api_key=${Const.apiKey}")
    fun getLatestDetail(@Path("id") id: Int): Call<LatestDetailResponse>
}
