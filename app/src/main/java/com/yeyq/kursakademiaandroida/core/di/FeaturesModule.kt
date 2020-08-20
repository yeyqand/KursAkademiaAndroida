package com.yeyq.kursakademiaandroida.core.di

import com.yeyq.kursakademiaandroida.features.characters.di.characterModule
import com.yeyq.kursakademiaandroida.features.episodes.di.episodeModule
import com.yeyq.kursakademiaandroida.features.locations.di.locationModule

val featuresModule = listOf(
    episodeModule,
    characterModule,
    locationModule
)