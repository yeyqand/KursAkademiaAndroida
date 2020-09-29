package com.yeyq.kursakademiaandroida.features.episodes.details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yeyq.kursakademiaandroida.core.base.BaseViewModel
import com.yeyq.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

class EpisodeDetailsViewModel : BaseViewModel() {

    private val _episode = MutableLiveData<EpisodeDisplayable>()

    val episode: LiveData<EpisodeDisplayable> by lazy {
        _episode
    }

    fun setEpisode(episode: EpisodeDisplayable) {
        _episode.value = episode
    }

}