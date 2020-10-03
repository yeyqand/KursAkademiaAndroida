package com.yeyq.kursakademiaandroida.features.episodes.details.presentation

import android.os.Bundle
import androidx.lifecycle.observe
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import kotlinx.android.synthetic.main.fragment_episode_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeDetailsFragment :
    BaseFragment<EpisodeDetailsViewModel>(R.layout.fragment_episode_details) {

    override val viewModel: EpisodeDetailsViewModel by viewModel()

    companion object {
        const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutData()
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisode()
    }

    private fun notifyAboutData() {
        arguments
            ?.getParcelable<EpisodeDisplayable>(EPISODE_DETAILS_KEY)
            ?.let { viewModel.onEpisodePassed(it) }
    }

    private fun observeEpisode() {
        viewModel.episode.observe(this) {
            showEpisodeDetails(it)
        }
    }

    private fun showEpisodeDetails(episode: EpisodeDisplayable) {
        codeTextView.text = episode.code
        titleTextView.text = episode.name
        airDateTextView.text = getString(R.string.air_date, episode.airDate)
    }
}