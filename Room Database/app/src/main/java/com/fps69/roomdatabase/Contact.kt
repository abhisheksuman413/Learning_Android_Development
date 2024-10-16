package com.fps69.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "contact")
data class Contact(

    @PrimaryKey(autoGenerate = true)  // Here making id as a primary key and auto generate id value
    val id :Long,
    val name : String,
    val phone : String,
    val createddDate : Date,
    val isActive : Int
)
