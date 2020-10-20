package com.yeyq.kursakademiaandroida.features.locations.di

import com.yeyq.kursakademiaandroida.features.locations.all.presentation.LocationsAdapter
import com.yeyq.kursakademiaandroida.features.locations.all.presentation.LocationsFragment
import com.yeyq.kursakademiaandroida.features.locations.data.repository.LocationRepositoryImpl
import com.yeyq.kursakademiaandroida.features.locations.domain.GetLocationsUseCase
import com.yeyq.kursakademiaandroida.features.locations.domain.LocationRepository
import com.yeyq.kursakademiaandroida.features.locations.navigation.LocationNavigator
import com.yeyq.kursakademiaandroida.features.locations.navigation.LocationNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent


@InstallIn(ApplicationComponent::class)
@Module
abstract class LocationModule {
    @Binds
    abstract fun bindLocationRepositoryImpl(repository: LocationRepositoryImpl):
            LocationRepository

    @Binds
    abstract fun bindLocationNavigatorImpl(navigator: LocationNavigatorImpl):
            LocationNavigator

    companion object {
        @Provides
        fun provideLocationsUseCase(locationRepository: LocationRepository) =
            GetLocationsUseCase(locationRepository)

        @Provides
        fun provideLocationsFragment() =
            LocationsFragment()

        @Provides
        fun provideLocationsAdapter() =
            LocationsAdapter()

    }
}