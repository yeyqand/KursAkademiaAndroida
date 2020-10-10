package com.yeyq.kursakademiaandroida.features.locations.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeyq.kursakademiaandroida.core.base.BaseAdapter
import com.yeyq.kursakademiaandroida.databinding.ItemLocationBinding
import com.yeyq.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable

class LocationsAdapter : BaseAdapter<LocationDisplayable>() {

    lateinit var listener: OnLocationsListener

    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLocationBinding.inflate(inflater, parent, false)

        return LocationViewHolder(binding, listener)
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val location = items[position]
        (holder as LocationViewHolder).bind(location)
    }

    class LocationViewHolder(
        private val binding: ItemLocationBinding,
        private val listener: OnLocationsListener
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(location: LocationDisplayable) {
            with(binding) {
                item = location
                root.setOnClickListener { listener.onClick(location) }
                executePendingBindings()
            }
        }
    }

    interface OnLocationsListener {
        fun onClick(locationDisplayable: LocationDisplayable)
    }
}