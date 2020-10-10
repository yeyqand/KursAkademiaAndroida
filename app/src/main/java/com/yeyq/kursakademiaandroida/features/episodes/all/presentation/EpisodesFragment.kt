package com.yeyq.kursakademiaandroida.features.episodes.all.presentation

import androidx.recyclerview.widget.RecyclerView
import com.yeyq.kursakademiaandroida.BR
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.databinding.FragmentEpisodesBinding
import com.yeyq.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import kotlinx.android.synthetic.main.fragment_episodes.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodesFragment : BaseFragment<EpisodesViewModel, FragmentEpisodesBinding>(
    BR.viewModel,
    R.layout.fragment_episodes
),
    EpisodesAdapter.OnEpisodesListener {

    override val viewModel: EpisodesViewModel by viewModel()
    private val adapter: EpisodesAdapter by inject()
    private val layoutManager: RecyclerView.LayoutManager by inject()

    override fun initViews(binding: FragmentEpisodesBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentEpisodesBinding) {
        with(binding.recyclerView) {
            layoutManager = this@EpisodesFragment.layoutManager
            adapter = this@EpisodesFragment.adapter
        }
        adapter.listener = this
    }

    override fun onDestroyView() {
        binding?.recyclerView?.let {
            it.layoutManager = null
            it.adapter = null
        }
        with(recyclerView) {
            layoutManager = null
            adapter = null
        }
        super.onDestroyView()
    }

    override fun onClick(episodeDisplayable: EpisodeDisplayable) {
        viewModel.onEpisodeClick(episodeDisplayable)
    }

}