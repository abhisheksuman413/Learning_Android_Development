package com.fps69.mvvmwithretrofit.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fps69.mvvmwithretrofit.Modle.Article


@Database(entities = [Article::class], version = 1)
abstract class NewsDatabase :RoomDatabase(){



    abstract fun newsDao():NewsDao


    companion object{

        private var INSTANCE : NewsDatabase?= null


        fun getDatabase(context : Context) : NewsDatabase{
            if(INSTANCE == null)
            {
                synchronized(this){
                    INSTANCE=Room.databaseBuilder(context,
                        NewsDatabase::class.java,
                        "news")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}