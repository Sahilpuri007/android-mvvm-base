package com.spinplanet.mvvmbase.data.local.database

import android.content.Context
import com.spinplanet.mvvmbase.data.local.entity.DataResponse
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.spinplanet.mvvmbase.data.local.dao.DataDao
import com.spinplanet.mvvmbase.data.local.typeconverter.DataTypeConverter


@Database(entities = [DataResponse::class], version = 1)
@TypeConverters(DataTypeConverter::class)
abstract class MvvmDatabase : RoomDatabase() {

    abstract fun dataDao(): DataDao

    companion object {
        private const val DATABASE_NAME = "mvvm-app"

        @Volatile
        private var INSTANCE: MvvmDatabase? = null

        fun getInstance(context: Context): MvvmDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MvvmDatabase::class.java,
                        DATABASE_NAME
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }

    }

}