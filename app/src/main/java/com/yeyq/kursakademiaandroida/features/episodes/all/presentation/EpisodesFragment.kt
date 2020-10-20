package com.yeyq.kursakademiaandroida.features.episodes.all.presentation

import androidx.fragment.app.viewModels
import com.yeyq.kursakademiaandroida.BR
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.databinding.FragmentEpisodesBinding
import com.yeyq.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class EpisodesFragment : BaseFragment<EpisodesViewModel, FragmentEpisodesBinding>(
    BR.viewModel,
    R.layout.fragment_episodes
),
    EpisodesAdapter.OnEpisodesListener {

    @Inject
    lateinit var adapter: EpisodesAdapter

    override val viewModel: EpisodesViewModel by viewModels()

    override fun initViews(binding: FragmentEpisodesBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentEpisodesBinding) {
        binding.recyclerView.adapter = adapter
        adapter.listener = this
    }

    override fun onClick(episodeDisplayable: EpisodeDisplayable) {
        viewModel.onEpisodeClick(episodeDisplayable)
    }

}