package com.example.gamecatalogue.utils

import com.example.gamecatalogue.network.response.LatestDetailResponse
import com.example.gamecatalogue.network.response.PopularDetailResponse
import com.example.gamecatalogue.network.response.LatestResponse
import com.example.gamecatalogue.network.response.PopularResponse
import com.example.gamecatalogue.presentation.model.Latest
import com.example.gamecatalogue.presentation.model.Popular

object Mapper {
    fun toPopular(popularResponse: PopularResponse): List<Popular> {
        val populars: MutableList<Popular> = mutableListOf()
        var popular: Popular
        popularResponse.results?.forEach {
            it?.let { popularResponseItem ->
                popular = Popular(
                    name = popularResponseItem.name ?: "",
                    backgroundimage = popularResponseItem.backgroundimage ?: "",
                    id = popularResponseItem.id ?: 0,
                    released = popularResponseItem.released ?: "",
                    description = popularResponseItem.description ?: ""
                )
                populars.add(popular)
            }
        }
        return populars
    }

    fun toLatest(latestResponse: LatestResponse): List<Latest> {
        val latests: MutableList<Latest> = mutableListOf()
        var latest: Latest
        latestResponse.results?.forEach {
            it?.let { latestResponseItem ->
                latest = Latest(
                    name = latestResponseItem.name ?: "",
                    backgroundimage = latestResponseItem.backgroundimage ?: "",
                    id = latestResponseItem.id ?: 0,
                    released = latestResponseItem.released ?: "",
                    description = latestResponseItem.description ?: ""
                )
                latests.add(latest)
            }
        }
        return latests
    }

    fun toPopularDetail(popularDetailResponse: PopularDetailResponse): Popular {
        return Popular(
            released = popularDetailResponse.released ?: "",
            name = popularDetailResponse.name ?: "",
            backgroundimage = popularDetailResponse.backgroundimage ?: "",
            id = popularDetailResponse.id ?: 0,
            description = popularDetailResponse.description ?: ""
        )
    }

    fun toLatestDetail(latestDetailResponse: LatestDetailResponse): Latest {
        return Latest(
            released = latestDetailResponse.released ?: "",
            name = latestDetailResponse.name ?: "",
            backgroundimage = latestDetailResponse.backgroundimage ?: "",
            id = latestDetailResponse.id ?: 0,
            description = latestDetailResponse.description ?: ""
        )
    }
}