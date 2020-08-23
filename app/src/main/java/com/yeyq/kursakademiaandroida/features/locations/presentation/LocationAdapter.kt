package com.yeyq.kursakademiaandroida.features.locations.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseAdapter
import com.yeyq.kursakademiaandroida.features.locations.presentation.model.LocationDisplayable
import kotlinx.android.synthetic.main.item_location.view.*

class LocationAdapter : BaseAdapter<LocationDisplayable>() {

    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_location, parent, false)

        return LocationViewHolder(
            itemView
        )
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val location = items[position]
        (holder as LocationViewHolder).bind(location)
    }

    class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(location: LocationDisplayable) {
            with(itemView) {
                dimensionTextView.text = location.dimension
                nameTextView.text = location.name
                typeTextView.text = location.type
            }
        }
    }
}