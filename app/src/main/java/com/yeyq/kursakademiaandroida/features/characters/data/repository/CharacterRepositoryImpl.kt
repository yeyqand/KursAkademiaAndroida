package com.yeyq.kursakademiaandroida.features.characters.data.repository

import com.yeyq.kursakademiaandroida.core.api.RickAndMortyApi
import com.yeyq.kursakademiaandroida.core.network.NetworkStateProvider
import com.yeyq.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import com.yeyq.kursakademiaandroida.features.characters.data.local.model.CharacterDao
import com.yeyq.kursakademiaandroida.features.characters.domain.CharacterRepository
import com.yeyq.kursakademiaandroida.features.characters.domain.model.Character

class CharacterRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val characterDao: CharacterDao,
    private val networkStateProvider: NetworkStateProvider
) : CharacterRepository {

    override suspend fun getCharacters(): List<Character> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getCharactersFromRemote()
                .also { saveCharactersToLocal(it) }
        } else {
            getCharacterFromLocal()
        }
    }

    private suspend fun getCharactersFromRemote(): List<Character> {
        return rickAndMortyApi.getCharacters()
            .result
            .map { it.toCharacter() }
            .also { saveCharactersToLocal(it) }
    }

    private suspend fun saveCharactersToLocal(episodes: List<Character>) {
        episodes.map { CharacterCached(it) }
            .toTypedArray()
            .let { characterDao.saveCharacters(*it) }
    }

    private suspend fun getCharacterFromLocal() =
        characterDao.getCharacters()
            .map { it.toCharacter() }

}