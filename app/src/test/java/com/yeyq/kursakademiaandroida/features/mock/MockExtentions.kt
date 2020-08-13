package com.yeyq.kursakademiaandroida.features.mock

import com.yeyq.kursakademiaandroida.core.api.model.*
import com.yeyq.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.yeyq.kursakademiaandroida.features.locations.data.local.model.LocationCached
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
