package com.yeyq.kursakademiaandroida.core.exception

interface ErrorMapper {
    fun map(throwable: Throwable): String
}