package com.fachrizalmrsln.component.network

@Suppress("unused", "MemberVisibilityCanBePrivate")
sealed class NetworkResult<out T : Any?> {

    class Success<out T : Any>(
        val value: T?,
        val message: String = ""
    ) : NetworkResult<T>() {
        override fun toString() = "Result.Ok{value=$value, response=$message}"
    }

    class Exception(
        val exception: kotlin.Exception
    ) : NetworkResult<Nothing>() {
        override fun toString() = "Result.Exception{$exception}"
    }

}

