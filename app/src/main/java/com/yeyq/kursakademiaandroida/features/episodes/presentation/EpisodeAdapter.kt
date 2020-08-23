package com.yeyq.kursakademiaandroida.features.episodes.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseAdapter
import com.yeyq.kursakademiaandroida.features.episodes.presentation.model.EpisodeDisplayable
import kotlinx.android.synthetic.main.item_episode.view.*

class EpisodeAdapter : BaseAdapter<EpisodeDisplayable>() {

    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_episode, parent, false)

        return EpisodeViewHolder(
            itemView
        )
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val episode = items[position]
        (holder as EpisodeViewHolder).bind(episode)
    }

    class EpisodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(episode: EpisodeDisplayable) {
            with(itemView) {
                codeTextView.text = episode.code
                titleTextView.text = episode.name
                airDateTextView.text = episode.airDate
            }
        }
    }
}