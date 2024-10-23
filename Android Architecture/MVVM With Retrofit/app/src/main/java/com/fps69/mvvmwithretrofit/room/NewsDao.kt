package com.fps69.mvvmwithretrofit.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.fps69.mvvmwithretrofit.Modle.Article


@Dao
interface NewsDao {


    @Insert
    suspend fun aadNews(news : List<Article>)

    @Query("SELECT * FROM news")
    suspend fun getNews(): List<Article>
}