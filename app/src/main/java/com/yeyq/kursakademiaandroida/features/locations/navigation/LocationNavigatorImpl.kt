package com.yeyq.kursakademiaandroida.features.locations.navigation

import com.yeyq.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable

interface LocationNavigator {
    fun openLocationDetailsScreen(lcoation: LocationDisplayable)
    fun goBack()
}