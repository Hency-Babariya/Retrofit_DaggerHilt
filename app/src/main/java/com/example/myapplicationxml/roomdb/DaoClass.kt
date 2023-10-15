package com.example.myapplicationxml.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myapplicationxml.Constants.MY_TABLE

@Dao
interface DaoClass {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(myEntity: MyEntity)

    @Update
    fun updateData(myEntity: MyEntity)

    @Delete
    fun deleteData(myEntity: MyEntity)

    @Query("SELECT * FROM $MY_TABLE ORDER BY id DESC")
    fun getAllData() : MutableList<MyEntity>

  /*  @Query("SELECT * FROM $MY_TABLE WHERE id LIKE :id")
    fun getById(id : Int) : MyEntity

    @Query("DELETE FROM $MY_TABLE")
    suspend fun deleteAllData()*/
}
