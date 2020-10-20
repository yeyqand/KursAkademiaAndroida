package com.yeyq.kursakademiaandroida.features.characters.di

import com.yeyq.kursakademiaandroida.features.characters.all.presentation.CharactersAdapter
import com.yeyq.kursakademiaandroida.features.characters.all.presentation.CharactersFragment
import com.yeyq.kursakademiaandroida.features.characters.data.repository.CharacterRepositoryImpl
import com.yeyq.kursakademiaandroida.features.characters.domain.CharacterRepository
import com.yeyq.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import com.yeyq.kursakademiaandroida.features.characters.navigation.CharacterNavigator
import com.yeyq.kursakademiaandroida.features.characters.navigation.CharacterNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent


@InstallIn(ApplicationComponent::class)
@Module
abstract class CharacterModule {
    @Binds
    abstract fun bindCharacterRepositoryImpl(repository: CharacterRepositoryImpl):
            CharacterRepository

    @Binds
    abstract fun bindCharacterNavigatorImpl(navigator: CharacterNavigatorImpl):
            CharacterNavigator

    companion object {
        @Provides
        fun provideCharactersUseCase(characterRepository: CharacterRepository) =
            GetCharactersUseCase(characterRepository)

        @Provides
        fun provideCharactersFragment() =
            CharactersFragment()

        @Provides
        fun provideCharactersAdapter() =
            CharactersAdapter()
    }
}