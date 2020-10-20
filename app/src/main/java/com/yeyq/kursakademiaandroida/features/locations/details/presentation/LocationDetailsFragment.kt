package com.yeyq.kursakademiaandroida.features.locations.details.presentation

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.yeyq.kursakademiaandroida.BR
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.databinding.FragmentCharacterDetailsBinding
import com.yeyq.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationDetailsFragment :
    BaseFragment<LocationDetailsViewModel, FragmentCharacterDetailsBinding>(
        BR.viewModel,
        R.layout.fragment_location_details
    ) {

    override val viewModel: LocationDetailsViewModel by viewModels()

    companion object {
        const val LOCATION_DETAILS_KEY = "locationDetailsKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutData()
    }

    private fun notifyAboutData() {
        arguments
            ?.getParcelable<LocationDisplayable>(LOCATION_DETAILS_KEY)
            ?.let { viewModel.onLocationPassed(it) }
    }
}