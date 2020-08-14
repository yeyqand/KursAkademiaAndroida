package com.yeyq.kursakademiaandroida.features.characters.domain

import com.yeyq.kursakademiaandroida.features.characters.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}