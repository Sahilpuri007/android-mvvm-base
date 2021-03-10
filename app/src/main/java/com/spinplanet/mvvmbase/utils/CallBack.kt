package com.spinplanet.mvvmbase.utils


interface CallBack<T> {
    fun onSuccess(response: T)
    fun onError(message: String)
}