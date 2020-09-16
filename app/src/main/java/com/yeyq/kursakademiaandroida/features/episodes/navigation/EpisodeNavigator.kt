package com.yeyq.kursakademiaandroida.features.episodes.navigation

import com.yeyq.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

interface EpisodeNavigator {
    fun openEpisodeDetailsScreen(episode: EpisodeDisplayable)
    fun goBack()
}