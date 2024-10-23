package com.fps69.abhishek.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fps69.abhishek.api.QuoteService
import com.fps69.abhishek.modle.MovieItem
import com.fps69.abhishek.modle.QuoteList

class QuotesRepository(private val quotesService: QuoteService) {

    private val quoteLiveData = MutableLiveData<List<MovieItem>>()

    val quotes : LiveData<List<MovieItem>>
        get() = quoteLiveData


    suspend fun getQuotes(){
        val result = quotesService.getQuotes()
        if(result?.body()!=null){
            quoteLiveData.postValue(result.body())
        }
    }

}