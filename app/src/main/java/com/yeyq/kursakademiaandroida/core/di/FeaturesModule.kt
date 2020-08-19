package com.yeyq.kursakademiaandroida.core.di

import com.yeyq.kursakademiaandroida.features.characters.di.characterModule
import com.yeyq.kursakademiaandroida.features.episodes.di.episodeModule

val featuresModule = listOf(
    episodeModule,
    characterModule
)