package com.fps69.mvvmwithretrofit.Modle

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)