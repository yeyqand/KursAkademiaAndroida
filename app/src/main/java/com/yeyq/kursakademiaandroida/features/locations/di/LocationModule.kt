package com.yeyq.kursakademiaandroida.features.locations.di

import com.yeyq.kursakademiaandroida.features.locations.all.presentation.LocationsAdapter
import com.yeyq.kursakademiaandroida.features.locations.all.presentation.LocationsFragment
import com.yeyq.kursakademiaandroida.features.locations.all.presentation.LocationsViewModel
import com.yeyq.kursakademiaandroida.features.locations.data.repository.LocationRepositoryImpl
import com.yeyq.kursakademiaandroida.features.locations.details.presentation.LocationDetailsViewModel
import com.yeyq.kursakademiaandroida.features.locations.domain.GetLocationsUseCase
import com.yeyq.kursakademiaandroida.features.locations.domain.LocationRepository
import com.yeyq.kursakademiaandroida.features.locations.navigation.LocationNavigator
import com.yeyq.kursakademiaandroida.features.locations.navigation.LocationNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationModule = module {
    //data
    factory<LocationRepository> { LocationRepositoryImpl(get(), get(), get(), get()) }
    factory { GetLocationsUseCase(get()) }

    //domain
    viewModel { LocationsViewModel(get(), get(), get()) }
    viewModel { LocationDetailsViewModel() }

    //presentation
    factory { LocationsFragment() }
    factory { LocationsAdapter() }
    factory<LocationNavigator> { LocationNavigatorImpl(get()) }
}