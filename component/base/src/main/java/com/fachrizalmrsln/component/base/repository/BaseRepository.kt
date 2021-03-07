@file:Suppress("unused")

package com.fachrizalmrsln.component.base.repository

import com.fachrizalmrsln.component.base.network.NetworkStateManager
import com.fachrizalmrsln.component.network.NetworkResult

open class BaseRepository(private val networkStateManager: NetworkStateManager) {

    protected suspend fun <T : Any> checkInternetAndAwaitResult(value: suspend () -> T): NetworkResult<T> {

        return if (networkStateManager.isOnline()) {
            try {
                NetworkResult.Success(value.invoke())
            } catch (e: Exception) {
                NetworkResult.Exception(e)
            }
        } else {
            NetworkResult.Exception(Exception("No Internet Access"))
        }
    }

    protected fun <T> NetworkResult<T>.onResultShow(
        onSuccess: (T?) -> Unit,
        onError: (Exception) -> Unit
    ) {
        if (this is NetworkResult.Success) onSuccess.invoke(value)
        else if (this is NetworkResult.Exception) onError.invoke(this.exception)
    }

}