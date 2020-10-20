package com.yeyq.kursakademiaandroida.features.characters.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeyq.kursakademiaandroida.core.base.BaseAdapter
import com.yeyq.kursakademiaandroida.databinding.ItemCharacterBinding
import com.yeyq.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

class CharactersAdapter : BaseAdapter<CharacterDisplayable>() {

    lateinit var listener: OnCharactersListener

    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterBinding.inflate(inflater, parent, false)

        return CharacterViewHolder(binding, listener)
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val character = items[position]
        (holder as CharacterViewHolder).bind(character)
    }

    class CharacterViewHolder(
        private val binding: ItemCharacterBinding,
        private val listener: OnCharactersListener
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: CharacterDisplayable) {
            with(binding) {
                item = character
                root.setOnClickListener { listener.onClick(character) }
                executePendingBindings()
            }
        }
    }

    interface OnCharactersListener {
        fun onClick(characterDisplayable: CharacterDisplayable)
    }
}