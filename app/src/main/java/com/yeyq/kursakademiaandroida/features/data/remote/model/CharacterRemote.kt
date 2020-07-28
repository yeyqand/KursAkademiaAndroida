package com.yeyq.kursakademiaandroida.features.data.remote.model

import com.google.gson.annotations.SerializedName
import com.yeyq.kursakademiaandroida.features.episodes.domain.model.Character
import com.yeyq.kursakademiaandroida.features.episodes.domain.model.Location
import com.yeyq.kursakademiaandroida.features.episodes.domain.model.Origin


data class CharacterRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val origin: OriginDTO,
    @SerializedName("location") val location: LocationDTO,
    @SerializedName("image") val image: String,
    @SerializedName("episode") val episodes: List<String>,
    @SerializedName("url") val url: String
) {
    fun toCharacter() = Character(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = origin.toOrigin(),
        location = location.toLocation(),
        image = image,
        episodes = episodes,
        url = url
    )
}

data class OriginDTO(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toOrigin() = Origin(
        name = name,
        url = url
    )
}

data class LocationDTO(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toLocation() = Location(
        name = name,
        url = url
    )
}