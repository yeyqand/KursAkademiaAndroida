package com.yeyq.kursakademiaandroida.features.episodes.domain.model

class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String
)