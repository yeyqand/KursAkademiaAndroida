package com.yeyq.kursakademiaandroida.core.api.model

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val result: List<CharacterRemote>
) {
    companion object
}