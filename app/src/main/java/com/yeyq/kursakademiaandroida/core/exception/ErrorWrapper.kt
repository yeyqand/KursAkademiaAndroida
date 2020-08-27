package com.yeyq.kursakademiaandroida.core.exception

interface ErrorWrapper {
    fun wrap(throwable: Throwable): Throwable
}