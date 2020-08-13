package com.yeyq.kursakademiaandroida.core.api

import com.yeyq.kursakademiaandroida.core.api.model.EpisodeResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episode")
    suspend fun getEpisodes(): EpisodeResponse
}