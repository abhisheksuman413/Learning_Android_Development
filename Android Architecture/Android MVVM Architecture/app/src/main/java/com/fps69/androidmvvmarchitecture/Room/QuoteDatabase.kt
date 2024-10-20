package com.fps69.androidmvvmarchitecture.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDao(): QuoteDao


    companion object {
        private var INSTANCES: QuoteDatabase? = null

        fun getDatabase(context: Context): QuoteDatabase {
            if (INSTANCES == null) {
                synchronized(this) {
                    INSTANCES = Room.databaseBuilder(
                        context,
                        QuoteDatabase::class.java,
                        "quote_database"
                    )
                        .createFromAsset("quotes.db")
                        .build()
                }
            }
            return INSTANCES!!
        }
    }

}