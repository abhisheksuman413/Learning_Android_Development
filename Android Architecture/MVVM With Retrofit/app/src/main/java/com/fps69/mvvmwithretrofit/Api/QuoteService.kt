package com.fps69.mvvmwithretrofit.Api

import com.fps69.mvvmwithretrofit.Modle.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {




    @GET("v2/top-headlines?apiKey=d33c7551a48646b4a54e0fbb43f5f3b9")
    suspend fun getQuotes(
        @Query("category") category : String,
        @Query("page") page : Int
    ) : Response<News>
}