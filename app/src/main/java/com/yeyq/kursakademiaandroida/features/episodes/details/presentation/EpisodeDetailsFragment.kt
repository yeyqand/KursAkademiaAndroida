package com.yeyq.kursakademiaandroida.features.episodes.details.presentation

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.yeyq.kursakademiaandroida.BR
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.databinding.FragmentEpisodesBinding
import com.yeyq.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeDetailsFragment :
    BaseFragment<EpisodeDetailsViewModel, FragmentEpisodesBinding>(
        BR.viewModel,
        R.layout.fragment_episode_details
    ) {

    override val viewModel: EpisodeDetailsViewModel by viewModels()

    companion object {
        const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutData()
    }

    private fun notifyAboutData() {
        arguments
            ?.getParcelable<EpisodeDisplayable>(EPISODE_DETAILS_KEY)
            ?.let { viewModel.onEpisodePassed(it) }
    }

}