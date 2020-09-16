package com.yeyq.kursakademiaandroida.features.episodes.di

import com.yeyq.kursakademiaandroida.features.episodes.all.presentation.EpisodesAdapter
import com.yeyq.kursakademiaandroida.features.episodes.all.presentation.EpisodesFragment
import com.yeyq.kursakademiaandroida.features.episodes.all.presentation.EpisodesViewModel
import com.yeyq.kursakademiaandroida.features.episodes.data.repository.EpisodeRepositoryImpl
import com.yeyq.kursakademiaandroida.features.episodes.details.presentation.EpisodeDetailsViewModel
import com.yeyq.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import com.yeyq.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import com.yeyq.kursakademiaandroida.features.episodes.navigation.EpisodeNavigator
import com.yeyq.kursakademiaandroida.features.episodes.navigation.EpisodeNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeModule = module {
    //data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get(), get()) }
    factory { GetEpisodesUseCase(get()) }

    //domain
    viewModel { EpisodesViewModel(get(), get(), get()) }
    viewModel { EpisodeDetailsViewModel() }

    //presentation
    factory { EpisodesFragment() }
    factory { EpisodesAdapter(get()) }
    factory<EpisodeNavigator> { EpisodeNavigatorImpl(get()) }
}