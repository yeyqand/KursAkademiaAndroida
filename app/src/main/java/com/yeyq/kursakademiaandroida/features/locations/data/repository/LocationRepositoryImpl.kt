package com.yeyq.kursakademiaandroida.features.locations.data.repository

import com.yeyq.kursakademiaandroida.core.api.RickAndMortyApi
import com.yeyq.kursakademiaandroida.core.exception.ErrorWrapper
import com.yeyq.kursakademiaandroida.core.exception.callOrThrow
import com.yeyq.kursakademiaandroida.core.network.NetworkStateProvider
import com.yeyq.kursakademiaandroida.features.locations.data.local.model.LocationCached
import com.yeyq.kursakademiaandroida.features.locations.data.local.model.LocationDao
import com.yeyq.kursakademiaandroida.features.locations.domain.LocationRepository
import com.yeyq.kursakademiaandroida.features.locations.domain.model.Location

class LocationRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val locationDao: LocationDao,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper
) : LocationRepository {

    override suspend fun getLocations(): List<Location> {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) { getLocationsFromRemote() }
                .also { saveLocationsToLocal(it) }
        } else {
            getLocationFromLocal()
        }
    }

    private suspend fun getLocationsFromRemote(): List<Location> {
        return rickAndMortyApi.getLocations()
            .result
            .map { it.toLocation() }
            .also { saveLocationsToLocal(it) }
    }

    private suspend fun saveLocationsToLocal(episodes: List<Location>) {
        episodes.map { LocationCached(it) }
            .toTypedArray()
            .let { locationDao.saveLocations(*it) }
    }

    private suspend fun getLocationFromLocal() =
        locationDao.getLocations()
            .map { it.toLocation() }

}