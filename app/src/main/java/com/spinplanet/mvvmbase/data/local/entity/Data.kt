package com.spinplanet.mvvmbase.data.local.entity

import com.google.gson.annotations.SerializedName

data class Data(
    val id: Int,

    @SerializedName("quantity")
    val quantity: String,

    @SerializedName("max_quantity")
    val maxQuantity: String,

    val title: String,

)