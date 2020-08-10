package com.yeyq.kursakademiaandroida.features.episodes.domain

import com.yeyq.kursakademiaandroida.core.base.UseCase
import com.yeyq.kursakademiaandroida.features.episodes.EpisodeRepository
import com.yeyq.kursakademiaandroida.features.episodes.domain.model.Episode

class GetEpisodesUseCase(private val episodeRepository: EpisodeRepository) :
    UseCase<List<Episode>, Unit>() {

    override suspend fun action(params: Unit) = episodeRepository.getEpisodes()
}