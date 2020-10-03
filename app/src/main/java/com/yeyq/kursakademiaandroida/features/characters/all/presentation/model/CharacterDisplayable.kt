package com.yeyq.kursakademiaandroida.features.characters.all.presentation.model

import android.os.Parcelable
import com.yeyq.kursakademiaandroida.features.characters.domain.model.Character
import com.yeyq.kursakademiaandroida.features.characters.domain.model.LocationCharacter
import com.yeyq.kursakademiaandroida.features.characters.domain.model.OriginCharacter
import kotlinx.android.parcel.Parcelize

@Parcelize
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
) : Parcelable {
    constructor(character: Character) : this(
        id = character.id,
        name = character.name,
        status = character.status,
        species = character.species,
        type = character.type,
        gender = character.gender,
        origin = OriginCharacterDisplayable(
            character.origin
        ),
        location = LocationCharacterDisplayable(
            character.location
        ),
        image = character.image,
        episodes = character.episodes,
        url = character.url
    )

    companion object
}

@Parcelize
data class OriginCharacterDisplayable(
    val name: String,
    val url: String
) : Parcelable {
    constructor(origin: OriginCharacter) : this(
        name = origin.name,
        url = origin.url
    )

    companion object
}

@Parcelize
data class LocationCharacterDisplayable(
    val name: String,
    val url: String
) : Parcelable {
    constructor(origin: LocationCharacter) : this(
        name = origin.name,
        url = origin.url
    )

    companion object
}