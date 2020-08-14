package com.yeyq.kursakademiaandroida.features.characters.data.local.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CharacterDao {

    @Query("SELECT * FROM CharacterCached")
    suspend fun getCharacters(): List<CharacterCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacters(vararg character: CharacterCached)
}