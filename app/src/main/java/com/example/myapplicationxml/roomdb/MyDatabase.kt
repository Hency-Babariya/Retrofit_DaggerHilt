package com.example.myapplicationxml.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MyEntity::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun dao(): DaoClass
}