package com.yeyq.kursakademiaandroida.features.episodes

import com.yeyq.kursakademiaandroida.features.episodes.domain.model.Episode

interface EpisodeRepository {
    suspend fun getEpisodes(): List<Episode>
}