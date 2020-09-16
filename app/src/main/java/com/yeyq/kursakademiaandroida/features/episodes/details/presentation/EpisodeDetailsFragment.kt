package com.yeyq.kursakademiaandroida.features.episodes.details.presentation

import android.os.Bundle
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import kotlinx.android.synthetic.main.fragment_episode_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeDetailsFragment :
    BaseFragment<EpisodeDetailsViewModel>(R.layout.fragment_episode_details) {

    override val viewModel: EpisodeDetailsViewModel by viewModel()
    private var episodeDisplayable: EpisodeDisplayable? = null

    companion object {
        const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            episodeDisplayable = it.getParcelable(EPISODE_DETAILS_KEY)
        }
    }

    override fun initViews() {
        super.initViews()
        showEpisodeDetails()
    }

    private fun showEpisodeDetails() {
        episodeDisplayable?.let {
            codeTextView.text = it.code
            titleTextView.text = it.name
            airDateTextView.text = getString(R.string.air_date, it.airDate)
        }
    }
}