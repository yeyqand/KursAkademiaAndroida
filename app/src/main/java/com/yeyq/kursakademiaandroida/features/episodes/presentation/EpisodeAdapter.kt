package com.yeyq.kursakademiaandroida.features.episodes.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.features.episodes.presentation.model.EpisodeDisplayable
import kotlinx.android.synthetic.main.item_episode.view.*

class EpisodeAdapter : RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    private val episodes by lazy { mutableListOf<EpisodeDisplayable>() }

    fun setEpisodes(episodes: List<EpisodeDisplayable>) {
        if (episodes.isNotEmpty()) {
            this.episodes.clear()
        }

        this.episodes.addAll(episodes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_episode, parent, false)

        return EpisodeViewHolder(
            itemView
        )
    }

    override fun getItemCount(): Int = episodes.size

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = episodes[position]
        holder.bind(episode)
    }

    class EpisodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(episode: EpisodeDisplayable) {
            with(itemView) {
                textView.text = episode.name
            }
        }
    }
}