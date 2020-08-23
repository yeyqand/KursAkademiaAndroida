package com.yeyq.kursakademiaandroida.features.characters.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseAdapter
import com.yeyq.kursakademiaandroida.features.characters.presentation.model.CharacterDisplayable
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterAdapter : BaseAdapter<CharacterDisplayable>() {

    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_character, parent, false)

        return CharacterViewHolder(
            itemView
        )
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val character = items[position]
        (holder as CharacterViewHolder).bind(character)
    }

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(character: CharacterDisplayable) {
            with(itemView) {
                textView.text = character.name
                Glide.with(this)
                    .load(character.image)
                    .into(imageView)
            }
        }
    }
}