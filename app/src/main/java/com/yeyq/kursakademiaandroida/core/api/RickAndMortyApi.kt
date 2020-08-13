package com.yeyq.kursakademiaandroida.core.api

import com.yeyq.kursakademiaandroida.core.api.model.EpisodeResponse
import com.yeyq.kursakademiaandroida.core.api.model.LocationResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episode")
    suspend fun getEpisodes(): EpisodeResponse

    @GET("location")
    suspend fun getLocations(): LocationResponse
}