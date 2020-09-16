package com.yeyq.kursakademiaandroida.features.locations.all.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseAdapter
import com.yeyq.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import kotlinx.android.synthetic.main.item_location.view.*

class LocationsAdapter(private val locationsViewModel: LocationsViewModel) :
    BaseAdapter<LocationDisplayable>() {

    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_location, parent, false)

        return LocationViewHolder(
            itemView,
            locationsViewModel
        )
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val location = items[position]
        (holder as LocationViewHolder).bind(location)
    }

    class LocationViewHolder(itemView: View, val locationsViewModel: LocationsViewModel) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(location: LocationDisplayable) {
            with(itemView) {
                dimensionTextView.text = location.dimension
                nameTextView.text = location.name
                typeTextView.text = location.type
                setOnClickListener {
                    locationsViewModel.onLocationClick(location)
                }
            }
        }
    }
}