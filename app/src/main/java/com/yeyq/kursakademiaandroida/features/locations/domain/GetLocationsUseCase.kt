package com.yeyq.kursakademiaandroida.features.locations.domain

import com.yeyq.kursakademiaandroida.core.base.UseCase
import com.yeyq.kursakademiaandroida.features.locations.LocationRepository
import com.yeyq.kursakademiaandroida.features.locations.domain.model.Location

class GetLocationsUseCase(private val locationRepository: LocationRepository) :
    UseCase<List<Location>, Unit>() {

    override suspend fun action(params: Unit) = locationRepository.getLocations()
}