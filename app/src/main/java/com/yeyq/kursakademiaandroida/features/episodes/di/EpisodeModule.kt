package com.yeyq.kursakademiaandroida.features.episodes.di

import com.yeyq.kursakademiaandroida.features.episodes.all.presentation.EpisodesAdapter
import com.yeyq.kursakademiaandroida.features.episodes.all.presentation.EpisodesFragment
import com.yeyq.kursakademiaandroida.features.episodes.data.repository.EpisodeRepositoryImpl
import com.yeyq.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import com.yeyq.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import com.yeyq.kursakademiaandroida.features.episodes.navigation.EpisodeNavigator
import com.yeyq.kursakademiaandroida.features.episodes.navigation.EpisodeNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
abstract class EpisodeModule {
    @Binds
    abstract fun bindEpisodeRepositoryImpl(repository: EpisodeRepositoryImpl):
            EpisodeRepository

    @Binds
    abstract fun bindEpisodeNavigatorImpl(navigator: EpisodeNavigatorImpl):
            EpisodeNavigator

    companion object {
        @Provides
        fun provideEpisodesUseCase(episodeRepository: EpisodeRepository) =
            GetEpisodesUseCase(episodeRepository)

        @Provides
        fun provideEpisodesFragment() =
            EpisodesFragment()

        @Provides
        fun provideEpisodesAdapter() =
            EpisodesAdapter()

    }
}

//val episodeModule = module {
//    //data
//    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get(), get()) }
//    factory { GetEpisodesUseCase(get()) }
//
//    //domain
//    viewModel { EpisodesViewModel(get(), get(), get()) }
//    viewModel { EpisodeDetailsViewModel() }
//
//    //presentation
//    factory { EpisodesFragment() }
//    factory { EpisodesAdapter() }
//    factory<EpisodeNavigator> { EpisodeNavigatorImpl(get()) }
//}