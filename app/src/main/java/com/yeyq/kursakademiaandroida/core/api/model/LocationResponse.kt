package com.yeyq.kursakademiaandroida.core.api.model

import com.google.gson.annotations.SerializedName

data class LocationResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val result: List<LocationRemote>
) {
    companion object
}