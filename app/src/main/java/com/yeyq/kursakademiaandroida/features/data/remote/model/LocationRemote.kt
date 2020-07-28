package com.yeyq.kursakademiaandroida.features.data.remote.model

import com.google.gson.annotations.SerializedName
import com.yeyq.kursakademiaandroida.features.episodes.domain.model.Location


data class LocationRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String,
    @SerializedName("dimension") val dimension: String,
    @SerializedName("residents") val residents: List<String>,
    @SerializedName("url") val url: String
) {
    fun toLocation() = Location(
        id = id,
        name = name,
        type = type,
        dimension = dimension,
        residents = residents,
        url = url
    )
}