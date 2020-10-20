package com.yeyq.kursakademiaandroida.core.di

import com.yeyq.kursakademiaandroida.BASE_URL
import com.yeyq.kursakademiaandroida.BuildConfig
import com.yeyq.kursakademiaandroida.core.api.RickAndMortyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
abstract class NetworkModule {
    companion object {
        @Provides
        @Singleton
        internal fun provideLoggingInterceptor() = HttpLoggingInterceptor()
            .apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            }

        @Provides
        @Singleton
        internal fun provideOkHttpClient(logging: HttpLoggingInterceptor) = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        @Provides
        @Singleton
        internal fun provideGsonConverterFactory() = GsonConverterFactory.create()

        @Provides
        @Singleton
        internal fun provideRetrofit(
            okHttpClient: OkHttpClient,
            gsonConverterFactory: GsonConverterFactory
        ) = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()

        @Provides
        @Singleton
        internal fun provideApi(retrofit: Retrofit) = retrofit.create(RickAndMortyApi::class.java)
    }
}