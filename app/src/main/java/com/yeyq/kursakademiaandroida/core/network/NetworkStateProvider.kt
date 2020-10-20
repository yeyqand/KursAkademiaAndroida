package com.yeyq.kursakademiaandroida.core.network

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import javax.inject.Inject

class NetworkStateProviderImpl @Inject constructor(
    private val connectivityManager: ConnectivityManager
) : NetworkStateProvider {
    override fun isNetworkAvailable(): Boolean {
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                ?: return false

        return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
    }

}

interface NetworkStateProvider {
    fun isNetworkAvailable(): Boolean
}