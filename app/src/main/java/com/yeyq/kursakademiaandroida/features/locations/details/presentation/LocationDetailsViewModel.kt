package com.yeyq.kursakademiaandroida.features.locations.details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yeyq.kursakademiaandroida.core.base.BaseViewModel
import com.yeyq.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable

class LocationDetailsViewModel : BaseViewModel() {

    private val _location = MutableLiveData<LocationDisplayable>()

    val location: LiveData<LocationDisplayable> by lazy {
        _location
    }

    fun setLocation(location: LocationDisplayable) {
        _location.value = location
    }

}