package com.yeyq.kursakademiaandroida.features.data.remote.model

import com.google.gson.annotations.SerializedName
import com.yeyq.kursakademiaandroida.features.characters.domain.model.Character
import com.yeyq.kursakademiaandroida.features.characters.domain.model.LocationCharacter
import com.yeyq.kursakademiaandroida.features.characters.domain.model.OriginCharacter


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
    fun toCharacter() =
        Character(
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
    fun toOrigin() =
        OriginCharacter(
            name = name,
            url = url
        )
}

data class LocationDTO(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toLocation() =
        LocationCharacter(
            name = name,
            url = url
        )
}