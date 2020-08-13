package com.yeyq.kursakademiaandroida.features.mock

import com.yeyq.kursakademiaandroida.core.api.model.EpisodeRemote
import com.yeyq.kursakademiaandroida.core.api.model.EpisodeResponse
import com.yeyq.kursakademiaandroida.core.api.model.ResponseInfo
import com.yeyq.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
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