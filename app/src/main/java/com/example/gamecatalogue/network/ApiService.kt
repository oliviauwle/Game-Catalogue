package com.example.gamecatalogue.network;

import com.example.gamecatalogue.network.response.PopularDetailResponse
import com.example.gamecatalogue.network.response.LatestDetailResponse
import com.example.gamecatalogue.network.response.LatestResponse
import com.example.gamecatalogue.network.response.PopularResponse
import com.example.gamecatalogue.utils.Const
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("games?api_key=${Const.apiKey}")
    fun getPopular(): Call<PopularResponse>

    @GET("games?api_key=${Const.apiKey}&ordering=-released")
    fun getLatest(): Call<LatestResponse>

    @GET("games/{game_Id}?api_key=${Const.apiKey}")
    fun getPopularDetail(@Path("gameId") gameId: Int): Call<PopularDetailResponse>

    @GET("games/{game_Id}?api_key=${Const.apiKey}")
    fun getLatestDetail(@Path("gameId") gameId: Int): Call<LatestDetailResponse>

}
