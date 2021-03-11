package com.spinplanet.mvvmbase.utils.sharedpref

import android.content.Context
import com.google.gson.Gson
import com.spinplanet.mvvmbase.data.local.entity.Data

class SharedPrefUtil(context: Context) : SharedPref {

    private val DB_NAME = "MVVM_APP"

    private val sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE)

    override fun setString(key: String, value: String) {
        with(sharedPreferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    override fun getString(key: String): String {
        return sharedPreferences.getString(key, "")!!
    }

    override fun setData(user: Data) {
        with(sharedPreferences.edit()) {
            val writeValueAsString = Gson().toJson(user)
            putString("user", writeValueAsString)
            apply()
        }
    }

    override fun getData(): Data? {
        return when (val user = sharedPreferences.getString("user", null)) {
            null -> null
            else -> {
                Gson().fromJson(user, Data::class.java)
            }
        }
    }
}