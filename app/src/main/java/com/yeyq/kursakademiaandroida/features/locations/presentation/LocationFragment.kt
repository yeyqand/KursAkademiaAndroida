package com.yeyq.kursakademiaandroida.features.locations.presentation

import androidx.lifecycle.observe
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<LocationViewModel>(R.layout.fragment_location) {

    override val viewModel: LocationViewModel by viewModel()

    override fun initViews() {
        super.initViews()
        //initialize all view-related classes
    }

    override fun onIdleState() {
        super.onIdleState()
        //handle idle state
    }

    override fun onPendingState() {
        super.onPendingState()
        //handle pending state
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }

    private fun observeCharacters() {
        viewModel.locations.observe(this) {
            // display episodes
        }
    }

}