package com.yeyq.kursakademiaandroida.mock

import com.yeyq.kursakademiaandroida.core.api.model.*
import com.yeyq.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import com.yeyq.kursakademiaandroida.features.characters.domain.model.Character
import com.yeyq.kursakademiaandroida.features.characters.domain.model.LocationCharacter
import com.yeyq.kursakademiaandroida.features.characters.domain.model.LocationCharacter.Companion
import com.yeyq.kursakademiaandroida.features.characters.domain.model.OriginCharacter
import com.yeyq.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.yeyq.kursakademiaandroida.features.episodes.domain.model.Episode
import com.yeyq.kursakademiaandroida.features.locations.data.local.model.LocationCached
import com.yeyq.kursakademiaandroida.features.locations.domain.model.Location
import org.jetbrains.annotations.TestOnly

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 2,
    next = "next page url",
    prev = "prev page url"
)

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 1,
    name = "epsiode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)

@TestOnly
fun EpisodeResponse.Companion.mock() = EpisodeResponse(
    info = ResponseInfo.mock(),
    result = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 2,
    name = "epsiode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)

@TestOnly
fun LocationRemote.Companion.mock() = LocationRemote(
    id = 3,
    name = "location name",
    type = "location type",
    dimension = "location dimension",
    residents = emptyList(),
    url = "location url"
)

@TestOnly
fun LocationResponse.Companion.mock() = LocationResponse(
    info = ResponseInfo.mock(),
    result = listOf(
        LocationRemote.mock(),
        LocationRemote.mock(),
        LocationRemote.mock()
    )
)

@TestOnly
fun LocationCached.Companion.mock() = LocationCached(
    id = 3,
    name = "location name",
    type = "location type",
    dimension = "location dimension",
    residents = emptyList(),
    url = "location url"
)

@TestOnly
fun CharacterRemote.Companion.mock() = CharacterRemote(
    id = 4,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character type",
    gender = "character gender",
    origin = OriginDTO.mock(),
    location = LocationDTO.mock(),
    image = "location image",
    episodes = emptyList(),
    url = "character url"
)

@TestOnly
fun OriginDTO.Companion.mock() = OriginDTO(
    name = "origin name",
    url = "origin url"
)

@TestOnly
fun LocationDTO.Companion.mock() = LocationDTO(
    name = "location name",
    url = "location url"
)

@TestOnly
fun CharacterResponse.Companion.mock() = CharacterResponse(
    info = ResponseInfo.mock(),
    result = listOf(
        CharacterRemote.mock(),
        CharacterRemote.mock(),
        CharacterRemote.mock()
    )
)

@TestOnly
fun CharacterCached.Companion.mock() = CharacterCached(
    id = 4,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "type species",
    gender = "gender species",
    origin = OriginCharacter("origin name", "origin url"),
    location = LocationCharacter("location name", "location url"),
    image = "image species",
    episodes = emptyList(),
    url = "character url"
)

@TestOnly
fun Episode.Companion.mock() = Episode(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)

@TestOnly
fun Character.Companion.mock() = Character(
    id = 2,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character type",
    gender = "character gender",
    origin = OriginCharacter.mock(),
    location = Companion.mock(),
    image = "character image",
    episodes = emptyList(),
    url = "character url"
)

@TestOnly
fun OriginCharacter.Companion.mock() = OriginCharacter(
    name = "originCharacter name",
    url = "originCharacter url"
)

@TestOnly
fun Companion.mock() = LocationCharacter(
    name = "locationCharacter name",
    url = "locationCharacter url"
)

@TestOnly
fun Location.Companion.mock() = Location(
    id = 3,
    name = "location name",
    type = "location type",
    dimension = "location dimension",
    residents = emptyList(),
    url = "location url"
)