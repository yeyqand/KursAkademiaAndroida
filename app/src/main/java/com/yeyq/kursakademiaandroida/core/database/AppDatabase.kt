package com.yeyq.kursakademiaandroida.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yeyq.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import com.yeyq.kursakademiaandroida.features.characters.data.local.model.CharacterDao
import com.yeyq.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.yeyq.kursakademiaandroida.features.episodes.data.local.model.EpisodeDao
import com.yeyq.kursakademiaandroida.features.locations.data.local.model.LocationCached
import com.yeyq.kursakademiaandroida.features.locations.data.local.model.LocationDao

@Database(
    entities = [EpisodeCached::class, LocationCached::class, CharacterCached::class],
    version = 1
)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun episodeDao(): EpisodeDao
    abstract fun locationDao(): LocationDao
    abstract fun characterDao(): CharacterDao
}