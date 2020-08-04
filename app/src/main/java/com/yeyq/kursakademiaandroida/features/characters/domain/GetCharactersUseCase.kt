package com.yeyq.kursakademiaandroida.features.characters.domain

import com.yeyq.kursakademiaandroida.core.base.UseCase
import com.yeyq.kursakademiaandroida.features.characters.CharacterRepository
import com.yeyq.kursakademiaandroida.features.characters.domain.model.Character

class GetCharactersUseCase(private val characterRepository: CharacterRepository) :
    UseCase<List<Character>, Unit>() {

    override suspend fun action(params: Unit) = characterRepository.getCharacters()
}