package com.yeyq.kursakademiaandroida.features.locations.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.yeyq.kursakademiaandroida.core.base.BaseViewModel
import com.yeyq.kursakademiaandroida.core.exception.ErrorMapper
import com.yeyq.kursakademiaandroida.features.locations.domain.GetLocationsUseCase
import com.yeyq.kursakademiaandroida.features.locations.domain.model.Location
import com.yeyq.kursakademiaandroida.features.locations.presentation.model.LocationDisplayable


class LocationViewModel(
    private val getLocationsUseCase: GetLocationsUseCase,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    private val _locations by lazy {
        MutableLiveData<List<Location>>()
            .also(this::getLocations)
    }

    val locations: LiveData<List<LocationDisplayable>> by lazy {
        _locations.map { locations ->
            locations.map { LocationDisplayable(it) }
        }
    }

    private fun getLocations(locationLiveData: MutableLiveData<List<Location>>) {
        setPendingState()
        getLocationsUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { locationLiveData.value = it }
            result.onFailure(this::handleFailure)
        }
    }

}