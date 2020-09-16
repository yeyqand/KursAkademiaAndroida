package com.yeyq.kursakademiaandroida.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.navigation.navOptions
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.exception.ErrorMapper
import com.yeyq.kursakademiaandroida.core.exception.ErrorMapperImpl
import com.yeyq.kursakademiaandroida.core.exception.ErrorWrapper
import com.yeyq.kursakademiaandroida.core.exception.ErrorWrapperImpl
import com.yeyq.kursakademiaandroida.core.navigation.FragmentNavigator
import com.yeyq.kursakademiaandroida.core.navigation.FragmentNavigatorImpl
import com.yeyq.kursakademiaandroida.core.network.NetworkStateProvider
import com.yeyq.kursakademiaandroida.core.network.NetworkStateProviderImpl
import com.yeyq.kursakademiaandroida.core.provider.ActivityProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

const val GRID_COLUMN_NUMBER = 1

val appModule = module {

    factory { LinearLayoutManager(androidContext()) }

    factory<RecyclerView.LayoutManager> { GridLayoutManager(androidContext(), GRID_COLUMN_NUMBER) }

    factory { DividerItemDecoration(androidContext(), LinearLayoutManager.VERTICAL) }

    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }

    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }

    factory<ErrorWrapper> { ErrorWrapperImpl() }

    factory<ErrorMapper> { ErrorMapperImpl(androidContext()) }

    single(createdAtStart = true) { ActivityProvider(androidApplication()) }

    factory<FragmentNavigator> {
        FragmentNavigatorImpl(
            activityProvider = get(),
            navHostController = R.id.nav_host_fragment,
            homeDestinationRes = R.id.characters_screen,
            defaultNavOptions = get()
        )
    }

    factory {
        navOptions {
            anim { enter = R.anim.fragment_fade_enter }
            anim { exit = R.anim.fragment_fade_exit }
            anim { popEnter = R.anim.fragment_fade_enter }
            anim { popExit = R.anim.fragment_fade_exit }
        }
    }

}