package com.yeyq.kursakademiaandroida.features.locations.presentation

import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.features.locations.preentations.model.LocationDisplayable
import kotlinx.android.synthetic.main.fragment_episode.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<LocationViewModel>(R.layout.fragment_location) {

    override val viewModel: LocationViewModel by viewModel()
    private val adapter: LocationAdapter by inject()
    private val layoutManager: RecyclerView.LayoutManager by inject()

    override fun initViews() {
        super.initViews()
        initRecycler()
        //initialize all view-related classes
    }

    private fun initRecycler() {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
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
        observeLocations()
    }

    private fun observeLocations() {
        viewModel.locations.observe(this) {
            showLocations(it)
            // display locations
        }
    }

    private fun showLocations(locations: List<LocationDisplayable>) {
        adapter.setLocations(locations)
    }

}