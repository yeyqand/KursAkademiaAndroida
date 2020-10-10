package com.yeyq.kursakademiaandroida.features.locations.all.presentation

import androidx.recyclerview.widget.RecyclerView
import com.yeyq.kursakademiaandroida.BR
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.databinding.FragmentLocationsBinding
import com.yeyq.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import kotlinx.android.synthetic.main.fragment_episodes.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationsFragment : BaseFragment<LocationsViewModel, FragmentLocationsBinding>(
    BR.viewModel,
    R.layout.fragment_locations
),
    LocationsAdapter.OnLocationsListener {

    override val viewModel: LocationsViewModel by viewModel()
    private val adapter: LocationsAdapter by inject()
    private val layoutManager: RecyclerView.LayoutManager by inject()

    override fun initViews(binding: FragmentLocationsBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentLocationsBinding) {
        with(binding.recyclerView) {
            layoutManager = this@LocationsFragment.layoutManager
            adapter = this@LocationsFragment.adapter
        }
        adapter.listener = this
    }

    override fun onDestroyView() {
        binding?.recyclerView?.let {
            it.layoutManager = null
            it.adapter = null
        }
        with(recyclerView) {
            layoutManager = null
            adapter = null
        }
        super.onDestroyView()
    }

    override fun onClick(locationDisplayable: LocationDisplayable) {
        viewModel.onLocationClick(locationDisplayable)
    }

}