package com.yeyq.kursakademiaandroida.features.locations.di

import com.yeyq.kursakademiaandroida.features.locations.data.repository.LocationRepositoryImpl
import com.yeyq.kursakademiaandroida.features.locations.domain.GetLocationsUseCase
import com.yeyq.kursakademiaandroida.features.locations.domain.LocationRepository
import com.yeyq.kursakademiaandroida.features.locations.presentation.LocationFragment
import com.yeyq.kursakademiaandroida.features.locations.presentation.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationModule = module {
    //data
    factory<LocationRepository> { LocationRepositoryImpl(get(), get(), get()) }
    factory { GetLocationsUseCase(get()) }

    //domain
    viewModel { LocationViewModel(get()) }

    //presentation
    factory { LocationFragment() }

}