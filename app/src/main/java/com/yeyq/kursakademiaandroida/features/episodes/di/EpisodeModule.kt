package com.yeyq.kursakademiaandroida.features.episodes.di

import com.yeyq.kursakademiaandroida.features.episodes.data.repository.EpisodeRepositoryImpl
import com.yeyq.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import com.yeyq.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import com.yeyq.kursakademiaandroida.features.episodes.presentation.EpisodeAdapter
import com.yeyq.kursakademiaandroida.features.episodes.presentation.EpisodeFragment
import com.yeyq.kursakademiaandroida.features.episodes.presentation.EpisodeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeModule = module {
    //data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get()) }
    factory { GetEpisodesUseCase(get()) }

    //domain
    viewModel { EpisodeViewModel(get()) }

    //presentation
    factory { EpisodeFragment() }
    factory { EpisodeAdapter() }

}