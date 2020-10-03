package com.yeyq.kursakademiaandroida.features.locations.details.presentation

import android.os.Bundle
import androidx.lifecycle.observe
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import kotlinx.android.synthetic.main.fragment_location_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationDetailsFragment :
    BaseFragment<LocationDetailsViewModel>(R.layout.fragment_location_details) {

    override val viewModel: LocationDetailsViewModel by viewModel()

    companion object {
        const val LOCATION_DETAILS_KEY = "locationDetailsKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutData()
    }

    override fun initObservers() {
        super.initObservers()
        observeLocation()
    }

    private fun notifyAboutData() {
        arguments
            ?.getParcelable<LocationDisplayable>(LOCATION_DETAILS_KEY)
            ?.let { viewModel.onLocationPassed(it) }
    }

    private fun observeLocation() {
        viewModel.location.observe(this) {
            showLocationDetails(it)
        }
    }

    private fun showLocationDetails(location: LocationDisplayable) {
        dimensionTextView.text = location.dimension
        nameTextView.text = location.name
        typeTextView.text = location.type
    }
}