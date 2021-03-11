package com.spinplanet.mvvmbase.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spinplanet.mvvmbase.data.local.entity.DataResponse
import com.spinplanet.mvvmbase.model.BaseResponse

@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(dataResponse: DataResponse)

    @Query("select * from tbl_data")
    fun getData(): DataResponse

}