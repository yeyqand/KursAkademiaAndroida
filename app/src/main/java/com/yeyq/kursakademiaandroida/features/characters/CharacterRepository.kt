package com.yeyq.kursakademiaandroida.features.characters

import com.yeyq.kursakademiaandroida.features.characters.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}