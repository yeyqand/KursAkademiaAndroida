package com.yeyq.kursakademiaandroida.core.di

import android.content.Context
import androidx.room.Room
import com.yeyq.kursakademiaandroida.DATABASE_NAME
import com.yeyq.kursakademiaandroida.core.database.AppDatabase
import com.yeyq.kursakademiaandroida.features.characters.data.local.model.CharacterDao
import com.yeyq.kursakademiaandroida.features.episodes.data.local.model.EpisodeDao
import com.yeyq.kursakademiaandroida.features.locations.data.local.model.LocationDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
abstract class RoomModule {
    companion object {
        @Provides
        @Singleton
        fun provideDataBase(@ApplicationContext context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()

        @Provides
        @Singleton
        fun provideEpisodeDao(database: AppDatabase): EpisodeDao = database.episodeDao()

        @Provides
        @Singleton
        fun provideLocationDao(database: AppDatabase): LocationDao = database.locationDao()

        @Provides
        @Singleton
        fun provideCharacterDao(database: AppDatabase): CharacterDao = database.characterDao()
    }
}