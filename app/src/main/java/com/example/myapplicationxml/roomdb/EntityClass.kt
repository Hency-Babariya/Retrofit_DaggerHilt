package com.example.myapplicationxml.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplicationxml.Constants.MY_TABLE

@Entity(tableName = MY_TABLE)
data class MyEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "note_desc")
    val desc: String
)