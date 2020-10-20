package com.yeyq.kursakademiaandroida.features.locations.all.presentation

import androidx.fragment.app.viewModels
import com.yeyq.kursakademiaandroida.BR
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.databinding.FragmentLocationsBinding
import com.yeyq.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LocationsFragment : BaseFragment<LocationsViewModel, FragmentLocationsBinding>(
    BR.viewModel,
    R.layout.fragment_locations
),
    LocationsAdapter.OnLocationsListener {

    @Inject
    lateinit var adapter: LocationsAdapter

    override val viewModel: LocationsViewModel by viewModels()

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