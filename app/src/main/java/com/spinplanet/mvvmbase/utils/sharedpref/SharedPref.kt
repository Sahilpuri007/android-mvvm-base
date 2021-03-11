package com.spinplanet.mvvmbase.utils.sharedpref

import com.spinplanet.mvvmbase.data.local.entity.Data

interface SharedPref {
    fun setString(key: String, value: String)
    fun getString(key: String): String
    fun setData(user: Data)
    fun getData() : Data?
}