package com.spinplanet.mvvmbase.data.local.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.spinplanet.mvvmbase.data.local.entity.Data
import java.lang.reflect.Type

object DataTypeConverter {

    @TypeConverter
    @JvmStatic
    fun fromList(value: List<Data>) = Gson().toJson(value)

    @TypeConverter
    @JvmStatic
    fun toList(value: String): List<Data> {
        val listType: Type = object : TypeToken<List<Data>>() {}.type
        return Gson().fromJson(value, listType)
    }

}