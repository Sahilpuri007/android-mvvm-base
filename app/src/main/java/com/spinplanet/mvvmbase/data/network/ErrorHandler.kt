package com.spinplanet.mvvmbase.data.network

import android.content.Context
import com.spinplanet.mvvmbase.R
import java.io.IOException
import java.net.SocketTimeoutException

class ErrorHandler {
    companion object {

        const val NETWORK_ERROR = "Network Error!"
        const val REQUEST_TIMED_OUT = "Request Timed out!"
        const val SOMETHING_WENT_WRONG = "Something went wrong!"

        fun handleError(e: Throwable): String {
            return when (e) {
                is IOException -> NETWORK_ERROR
                is SocketTimeoutException -> REQUEST_TIMED_OUT
                else -> SOMETHING_WENT_WRONG
            }
        }
    }
}