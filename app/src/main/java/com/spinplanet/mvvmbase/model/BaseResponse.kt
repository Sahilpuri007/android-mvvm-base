package com.spinplanet.mvvmbase.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

/**
 * The Common Response model class
 */
data class BaseResponse(
    @SerializedName("statusCode") val statusCode: String,
    @SerializedName("message") val message: String,
    @SerializedName("type") val type: String,
    @SerializedName("data") val data: Any
) {

    override fun toString(): String {
        return "$statusCode $message\n$data"
    }

    /**
     * Parses the response into an instance of provided class
     *
     * @param classRef the class reference
     * @param <Any>      the class type
     * @return the parsed response object
    </T> */
    fun <Any> toResponseModel(classRef: Class<Any>): Any {
        return Gson().fromJson(Gson().toJson(data), classRef)
    }
}
