package com.yeyq.kursakademiaandroida.features.locations.all.presentation

import com.yeyq.kursakademiaandroida.BR
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.databinding.FragmentLocationsBinding
import com.yeyq.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationsFragment : BaseFragment<LocationsViewModel, FragmentLocationsBinding>(
    BR.viewModel,
    R.layout.fragment_locations
),
    LocationsAdapter.OnLocationsListener {

    override val viewModel: LocationsViewModel by viewModel()
    private val adapter: LocationsAdapter by inject()

    override fun initViews(binding: FragmentLocationsBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentLocationsBinding) {
        binding.recyclerView.adapter = adapter
        adapter.listener = this
    }

    override fun onClick(locationDisplayable: LocationDisplayable) {
        viewModel.onLocationClick(locationDisplayable)
    }

}