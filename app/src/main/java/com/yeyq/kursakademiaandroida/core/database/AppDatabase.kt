package com.yeyq.kursakademiaandroida.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yeyq.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.yeyq.kursakademiaandroida.features.episodes.data.local.model.EpisodeDao

@Database(entities = [EpisodeCached::class], version = 1)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun episodeDao(): EpisodeDao
}