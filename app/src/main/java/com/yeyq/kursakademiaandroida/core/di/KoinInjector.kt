package com.yeyq.kursakademiaandroida.core.di

import org.koin.core.module.Module

val koinInjector: List<Module> = featuresModule
    .plus(appModule)
    .plus(networkModule)
    .plus(roomModule)