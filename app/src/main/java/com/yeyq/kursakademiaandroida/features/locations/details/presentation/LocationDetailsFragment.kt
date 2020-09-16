package com.yeyq.kursakademiaandroida.features.locations.details.presentation

import android.os.Bundle
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import kotlinx.android.synthetic.main.fragment_location_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationDetailsFragment :
    BaseFragment<LocationDetailsViewModel>(R.layout.fragment_location_details) {

    override val viewModel: LocationDetailsViewModel by viewModel()
    private var locationDisplayable: LocationDisplayable? = null

    companion object {
        const val LOCATION_DETAILS_KEY = "locationDetailsKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            locationDisplayable = it.getParcelable(LOCATION_DETAILS_KEY)
        }
    }

    override fun initViews() {
        super.initViews()
        showLocationDetails()
    }

    private fun showLocationDetails() {
        locationDisplayable?.let {
            dimensionTextView.text = it.dimension
            nameTextView.text = it.name
            typeTextView.text = it.type
        }
    }
}