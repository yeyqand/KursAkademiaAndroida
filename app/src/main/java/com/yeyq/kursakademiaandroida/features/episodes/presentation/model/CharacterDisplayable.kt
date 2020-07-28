package com.yeyq.kursakademiaandroida.features.episodes.presentation.model

import com.yeyq.kursakademiaandroida.features.episodes.domain.model.Character
import com.yeyq.kursakademiaandroida.features.episodes.domain.model.Location
import com.yeyq.kursakademiaandroida.features.episodes.domain.model.Origin

data class CharacterDisplayable(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginDisplayable,
    val location: LocationDisplayable,
    val image: String,
    val episodes: List<String>,
    val url: String
) {
    constructor(character: Character) : this(
        id = character.id,
        name = character.name,
        status = character.status,
        species = character.species,
        type = character.type,
        gender = character.gender,
        origin = OriginDisplayable(character.origin),
        location = LocationDisplayable(character.location),
        image = character.image,
        episodes = character.episodes,
        url = character.url
    )
}

data class OriginDisplayable(
    val name: String,
    val url: String
) {
    constructor(origin: Origin) : this(
        name = origin.name,
        url = origin.url
    )
}

data class LocationDisplayable(
    val name: String,
    val url: String
) {
    constructor(origin: Location) : this(
        name = origin.name,
        url = origin.url
    )
}