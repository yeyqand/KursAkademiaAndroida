package com.yeyq.kursakademiaandroida.features.locations.domain

import com.yeyq.kursakademiaandroida.features.locations.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}