package com.fps69.roomdatabase

import androidx.room.TypeConverter
import java.util.Date


class Convertors {

    @TypeConverter
    fun fromDateTOLong(value : java.util.Date): Long{
        return value.time
    }

    @TypeConverter
    fun fromLongToDate( value : Long ) : Date{
        return Date(value)
    }
}