package com.yeyq.kursakademiaandroida.features.episodes.presentation

import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.features.episodes.presentation.model.EpisodeDisplayable
import kotlinx.android.synthetic.main.fragment_episode.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodeViewModel by viewModel()
    private val adapter: EpisodeAdapter by inject()
    private val layoutManager: RecyclerView.LayoutManager by inject()

    override fun initViews() {
        super.initViews()
        initRecycler()
        //initialize all view-related classes
    }

    private fun initRecycler() {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
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
            showEpisodes(it)
            // display episodes
        }
    }

    private fun showEpisodes(episodes: List<EpisodeDisplayable>) {
        adapter.setEpisodes(episodes)
    }

}