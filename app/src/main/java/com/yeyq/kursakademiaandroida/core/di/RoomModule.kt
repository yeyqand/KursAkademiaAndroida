package com.yeyq.kursakademiaandroida.core.di

import androidx.room.Room
import com.yeyq.kursakademiaandroida.DATABASE_NAME
import com.yeyq.kursakademiaandroida.core.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val roomModule = module {
    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, DATABASE_NAME)
            .build()
    }

    single { get<AppDatabase>().episodeDao() }
}