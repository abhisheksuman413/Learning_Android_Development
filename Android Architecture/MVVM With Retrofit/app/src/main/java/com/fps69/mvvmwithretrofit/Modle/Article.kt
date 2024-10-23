package com.fps69.mvvmwithretrofit.Modle

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "news")
data class Article(

    @PrimaryKey(autoGenerate = true)
    val newsId :Int,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String
)