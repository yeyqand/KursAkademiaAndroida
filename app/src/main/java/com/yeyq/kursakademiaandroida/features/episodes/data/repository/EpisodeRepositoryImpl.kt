package com.yeyq.kursakademiaandroida.features.episodes.data.repository

import com.yeyq.kursakademiaandroida.core.api.RickAndMortyApi
import com.yeyq.kursakademiaandroida.core.exception.ErrorWrapper
import com.yeyq.kursakademiaandroida.core.exception.callOrThrow
import com.yeyq.kursakademiaandroida.core.network.NetworkStateProvider
import com.yeyq.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.yeyq.kursakademiaandroida.features.episodes.data.local.model.EpisodeDao
import com.yeyq.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import com.yeyq.kursakademiaandroida.features.episodes.domain.model.Episode

class EpisodeRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val episodeDao: EpisodeDao,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper
) : EpisodeRepository {

    override suspend fun getEpisodes(): List<Episode> {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) { getEpisodesFromRemote() }
                .also { saveEpisodesToLocal(it) }
        } else {
            getEpisodesFromLocal()
        }
    }

    private suspend fun getEpisodesFromRemote(): List<Episode> {
        return rickAndMortyApi.getEpisodes()
            .result
            .map { it.toEpisode() }
            .also { saveEpisodesToLocal(it) }
    }

    private suspend fun saveEpisodesToLocal(episodes: List<Episode>) {
        episodes.map { EpisodeCached(it) }
            .toTypedArray()
            .let { episodeDao.saveEpisodes(*it) }
    }

    private suspend fun getEpisodesFromLocal() =
        episodeDao.getEpisodes()
            .map { it.toEpisode() }

}