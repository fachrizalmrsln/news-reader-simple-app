@file:Suppress("unused", "MemberVisibilityCanBePrivate", "PropertyName")

package com.fachrizalmrsln.component.base.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fachrizalmrsln.component.base.util.SingleLiveEvent
import com.fachrizalmrsln.component.network.NetworkResult

open class BaseViewModel : ViewModel() {

    protected val _message = SingleLiveEvent<Message>()
    val message: LiveData<Message> = _message

    private val _loadingStatus = MutableLiveData<Boolean>()
    val loadingStatus: LiveData<Boolean> = _loadingStatus

    protected fun <T> NetworkResult<T>.onResultShow(
        onSuccess: (T?) -> Unit,
        onError: (Exception) -> Unit
    ) {
        if (this is NetworkResult.Success) onSuccess.invoke(value)
        else if (this is NetworkResult.Exception) onError.invoke(this.exception)
    }

    protected fun showLoading() {
        _loadingStatus.value = true
    }

    protected fun hideLoading() {
        if (_loadingStatus.value == true) {
            _loadingStatus.value = false
        }
    }

}