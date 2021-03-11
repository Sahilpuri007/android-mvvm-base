package com.spinplanet.mvvmbase.utils

import java.text.SimpleDateFormat
import java.util.*

fun getCurrentTime(): String {

    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
    val time: Date = Calendar.getInstance().time
    return dateFormat.format(time)

}