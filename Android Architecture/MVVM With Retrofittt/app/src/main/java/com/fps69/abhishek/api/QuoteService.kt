package com.fps69.abhishek.api

import com.fps69.abhishek.modle.MovieItem
import com.fps69.abhishek.modle.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

    @GET("movies")
    suspend fun getQuotes(

//        @Query("page") page : Int

    ): Response<List<MovieItem>>
}