package com.fps69.androidmvvmarchitecture.Room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "quote")
data class Quote(


    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val text: String,
    val author: String


)
