package com.example.gamecatalogue.utils

import com.example.gamecatalogue.network.response.LatestDetailResponse
import com.example.gamecatalogue.network.response.LatestResponse
import com.example.gamecatalogue.network.response.PopularDetailResponse
import com.example.gamecatalogue.presentation.model.Latest
import com.example.gamecatalogue.presentation.model.Popular
import com.example.gamecatalogue.response.PopularResponse

object Mapper {
    fun toPopular(popularResponse: PopularResponse): List<Popular>{
        val populars: MutableList<Popular> = mutableListOf()
        var popular: Popular
        popularResponse.results?.forEach {
            it?.let { popularResponseItem ->
                popular = Popular(
                    overview = "",
                    name = popularResponseItem.name ?: "",
                    backgroundimage = popularResponseItem.backgroundimage ?: "",
                    id = popularResponseItem.id ?: 0
                )
                populars.add(popular)
            }
        }
        return populars
    }

    fun toLatest(latestResponse: LatestResponse): List<Latest>{
        val latests: MutableList<Latest> = mutableListOf()
        var latest: Latest
        latestResponse.results?.forEach {
            it?.let { latestResponseItem ->
                latest = Latest(
                    overview = latestResponseItem"",
                    name = latestResponseItem.name ?: "",
                    backgroundimage = latestResponseItem.backgroundimage ?: "",
                    id = latestResponseItem.id ?: 0
                )
                latests.add(latest)
            }
        }
        return latests
    }

    fun toPopularDetail(popularDetailResponse: PopularDetailResponse): Popular{
        return Popular(
            overview = "",
            name = popularDetailResponse.name ?: "",
            backgroundimage = popularDetailResponse.backgroundimage ?: "",
            id = popularDetailResponse.id ?: 0,
            developer = popularDetailResponse.developer ?:""
        )
    }

    fun toLatestDetail(popularDetailResponse: LatestDetailResponse): Latest{
        return Latest(
            overview = "",
            name = popularDetailResponse.name ?: "",
            backgroundimage = popularDetailResponse.backgroundimage ?: "",
            id = popularDetailResponse.id ?: 0,
            developer = popularDetailResponse.developer ?:""
        )
}