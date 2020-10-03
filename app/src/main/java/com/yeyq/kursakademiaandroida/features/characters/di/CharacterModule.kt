package com.yeyq.kursakademiaandroida.features.characters.di

import com.yeyq.kursakademiaandroida.features.characters.all.presentation.CharactersAdapter
import com.yeyq.kursakademiaandroida.features.characters.all.presentation.CharactersFragment
import com.yeyq.kursakademiaandroida.features.characters.all.presentation.CharactersViewModel
import com.yeyq.kursakademiaandroida.features.characters.data.repository.CharacterRepositoryImpl
import com.yeyq.kursakademiaandroida.features.characters.details.presentation.CharacterDetailsViewModel
import com.yeyq.kursakademiaandroida.features.characters.domain.CharacterRepository
import com.yeyq.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import com.yeyq.kursakademiaandroida.features.characters.navigation.CharacterNavigator
import com.yeyq.kursakademiaandroida.features.characters.navigation.CharacterNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    //data
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get(), get()) }
    factory { GetCharactersUseCase(get()) }

    //domain
    viewModel { CharactersViewModel(get(), get(), get()) }
    viewModel { CharacterDetailsViewModel() }

    //presentation
    factory { CharactersFragment() }
    factory { CharactersAdapter() }
    factory<CharacterNavigator> { CharacterNavigatorImpl(get()) }

}