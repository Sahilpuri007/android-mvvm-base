package com.spinplanet.mvvmbase.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.spinplanet.mvvmbase.data.local.typeconverter.DataTypeConverter


@Entity(tableName = "tbl_data")
class DataResponse (
    @PrimaryKey
    val page: Int = 1,
    @ColumnInfo(name = "movie_response")
    @TypeConverters(DataTypeConverter::class)
    val results: List<Data>
)