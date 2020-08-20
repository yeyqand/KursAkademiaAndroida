package com.yeyq.kursakademiaandroida.features.locations.preentations.model

import com.yeyq.kursakademiaandroida.features.locations.domain.model.Location


data class LocationDisplayable(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String
) {
    constructor(location: Location) : this(
        id = location.id,
        name = location.name,
        type = location.type,
        dimension = location.dimension,
        residents = location.residents,
        url = location.url
    )
}