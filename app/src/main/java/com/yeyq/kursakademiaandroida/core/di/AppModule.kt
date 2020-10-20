package com.yeyq.kursakademiaandroida.core.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.navigation.NavOptions
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
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

const val GRID_COLUMN_NUMBER = 1

@InstallIn(ApplicationComponent::class)
@Module
abstract class AppModule {
    @Binds
    abstract fun bindNetworkStateProviderImpl(provider: NetworkStateProviderImpl):
            NetworkStateProvider

    @Binds
    abstract fun bindErrorWrapperImpl(errorWrapper: ErrorWrapperImpl):
            ErrorWrapper

    @Binds
    abstract fun bindErrorMapperImpl(errorMapper: ErrorMapperImpl):
            ErrorMapper

    companion object {
        @Provides
        fun provideLinearLayoutManager(@ApplicationContext context: Context) =
            LinearLayoutManager(context)

        @Provides
        fun provideGridLayoutManager(@ApplicationContext context: Context): RecyclerView.LayoutManager =
            GridLayoutManager(context, GRID_COLUMN_NUMBER)

        @Provides
        fun provideDividerItemDecoration(
            @ApplicationContext context: Context,
            layoutManager: Int = LinearLayoutManager.VERTICAL
        ) =
            DividerItemDecoration(context, layoutManager)

        @Provides
        fun provideConnectivityManager(@ApplicationContext context: Context) =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        @Provides
        @Singleton
        fun provideActivityProvider(application: Application) =
            ActivityProvider(application)

        @Provides
        fun provideNavOptions() =
            navOptions {
                anim { enter = R.anim.fragment_fade_enter }
                anim { exit = R.anim.fragment_fade_exit }
                anim { popEnter = R.anim.fragment_fade_enter }
                anim { popExit = R.anim.fragment_fade_exit }
            }

        @Provides
        fun provideFragmentNavigator(
            activityProvider: ActivityProvider,
            defaultNavOptions: NavOptions
        ): FragmentNavigator =
            FragmentNavigatorImpl(
                activityProvider,
                R.id.nav_host_fragment,
                R.id.characters_screen,
                defaultNavOptions
            )
    }
}
