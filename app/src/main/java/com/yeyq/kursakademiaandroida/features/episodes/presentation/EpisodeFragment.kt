package com.yeyq.kursakademiaandroida.features.episodes.presentation

import androidx.lifecycle.observe
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodeViewModel by viewModel()

    override fun initViews() {
        super.initViews()
        //initialize all view-related classes
    }

    override fun onIdleState() {
        super.onIdleState()
        //handle idle state
    }

    override fun onPendingState() {
        super.onPendingState()
        //handle pending state
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            // display episodes
        }
    }

}