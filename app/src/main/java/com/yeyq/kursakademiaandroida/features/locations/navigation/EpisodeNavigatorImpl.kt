package com.yeyq.kursakademiaandroida.features.locations.navigation

import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.navigation.FragmentNavigator
import com.yeyq.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import com.yeyq.kursakademiaandroida.features.locations.details.presentation.LocationDetailsFragment

class LocationNavigatorImpl(private val fragmentNavigator: FragmentNavigator) : LocationNavigator {
    override fun openLocationDetailsScreen(episode: LocationDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_locations_screen_to_location_details_fragment,
            LocationDetailsFragment.LOCATION_DETAILS_KEY to episode
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}