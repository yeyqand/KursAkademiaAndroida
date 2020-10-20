package com.yeyq.kursakademiaandroida.features.episodes.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeyq.kursakademiaandroida.core.base.BaseAdapter
import com.yeyq.kursakademiaandroida.databinding.ItemEpisodeBinding
import com.yeyq.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import javax.inject.Inject

class EpisodesAdapter @Inject constructor() : BaseAdapter<EpisodeDisplayable>() {

    lateinit var listener: OnEpisodesListener

    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEpisodeBinding.inflate(inflater, parent, false)

        return EpisodeViewHolder(binding, listener)
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val episode = items[position]
        (holder as EpisodeViewHolder).bind(episode)
    }

    class EpisodeViewHolder(
        private val binding: ItemEpisodeBinding,
        private val listener: OnEpisodesListener
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(episode: EpisodeDisplayable) {
            with(binding) {
                item = episode
                root.setOnClickListener { listener.onClick(episode) }
                executePendingBindings()
            }
        }
    }

    interface OnEpisodesListener {
        fun onClick(episodeDisplayable: EpisodeDisplayable)
    }
}