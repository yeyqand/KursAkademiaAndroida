package com.yeyq.kursakademiaandroida.features.episodes.presentation.model

import com.yeyq.kursakademiaandroida.features.episodes.domain.model.Character
import com.yeyq.kursakademiaandroida.features.episodes.domain.model.LocationCharacter
import com.yeyq.kursakademiaandroida.features.episodes.domain.model.OriginCharacter

data class CharacterDisplayable(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginCharacterDisplayable,
    val location: LocationCharacterDisplayable,
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
        origin = OriginCharacterDisplayable(character.origin),
        location = LocationCharacterDisplayable(character.location),
        image = character.image,
        episodes = character.episodes,
        url = character.url
    )
}

data class OriginCharacterDisplayable(
    val name: String,
    val url: String
) {
    constructor(origin: OriginCharacter) : this(
        name = origin.name,
        url = origin.url
    )
}

data class LocationCharacterDisplayable(
    val name: String,
    val url: String
) {
    constructor(origin: LocationCharacter) : this(
        name = origin.name,
        url = origin.url
    )
}