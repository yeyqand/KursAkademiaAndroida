package com.yeyq.kursakademiaandroida.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.yeyq.kursakademiaandroida.core.network.NetworkStateProvider
import com.yeyq.kursakademiaandroida.core.network.NetworkStateProviderImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

const val GRID_COLUMN_NUMBER = 2

val appModule = module {

    factory { LinearLayoutManager(androidContext()) }

    factory { GridLayoutManager(androidContext(), GRID_COLUMN_NUMBER) }

    factory { DividerItemDecoration(androidContext(), LinearLayoutManager.VERTICAL) }

    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }

    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }
}