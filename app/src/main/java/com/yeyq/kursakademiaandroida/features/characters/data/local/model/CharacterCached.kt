package com.yeyq.kursakademiaandroida.features.characters.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yeyq.kursakademiaandroida.features.characters.domain.model.Character
import com.yeyq.kursakademiaandroida.features.characters.domain.model.LocationCharacter
import com.yeyq.kursakademiaandroida.features.characters.domain.model.OriginCharacter

@Entity
data class CharacterCached(
    @PrimaryKey
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    @Embedded(prefix = "OriginCharacter")
    val origin: OriginCharacter,
    @Embedded(prefix = "LocationCharacter")
    val location: LocationCharacter,
    val image: String,
    val episodes: List<String>,
    val url: String
) {

    constructor(character: Character) : this(
        character.id,
        character.name,
        character.status,
        character.species,
        character.type,
        character.gender,
        character.origin,
        character.location,
        character.image,
        character.episodes,
        character.url
    )

    companion object

    fun toCharacter() = Character(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = origin,
        location = location,
        image = image,
        episodes = episodes,
        url = url
    )

}