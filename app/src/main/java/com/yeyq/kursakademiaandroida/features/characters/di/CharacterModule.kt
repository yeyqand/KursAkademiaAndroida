package com.yeyq.kursakademiaandroida.features.characters.di

import com.yeyq.kursakademiaandroida.features.characters.data.repository.CharacterRepositoryImpl
import com.yeyq.kursakademiaandroida.features.characters.domain.CharacterRepository
import com.yeyq.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import com.yeyq.kursakademiaandroida.features.characters.presentation.CharacterAdapter
import com.yeyq.kursakademiaandroida.features.characters.presentation.CharacterFragment
import com.yeyq.kursakademiaandroida.features.characters.presentation.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    //data
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get()) }
    factory { GetCharactersUseCase(get()) }

    //domain
    viewModel { CharacterViewModel(get()) }

    //presentation
    factory { CharacterFragment() }
    factory { CharacterAdapter() }

}