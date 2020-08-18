package com.yeyq.kursakademiaandroida.core.api.model

import com.google.gson.annotations.SerializedName

data class EpisodeResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val result: List<EpisodeRemote>
) {
    companion object
}
