package com.yeyq.kursakademiaandroida.features.locations.all.presentation

import android.view.View
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import kotlinx.android.synthetic.main.fragment_episodes.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationsFragment : BaseFragment<LocationsViewModel>(R.layout.fragment_location) {

    override val viewModel: LocationsViewModel by viewModel()
    private val adapter: LocationsAdapter by inject()
    private val layoutManager: RecyclerView.LayoutManager by inject()

    override fun initViews() {
        super.initViews()
        initRecycler()
    }

    private fun initRecycler() {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    override fun onIdleState() {
        super.onIdleState()
        hideProgressBar()
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun onPendingState() {
        super.onPendingState()
        showProgressBar()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        with(recyclerView) {
            layoutManager = null
            adapter = null
        }
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun initObservers() {
        super.initObservers()
        observeLocations()
    }

    private fun observeLocations() {
        viewModel.locations.observe(this) {
            showLocations(it)
        }
    }

    private fun showLocations(locations: List<LocationDisplayable>) {
        adapter.setItems(locations)
    }

}