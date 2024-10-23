package com.fps69.mvvmwithretrofit.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fps69.mvvmwithretrofit.Api.QuoteService
import com.fps69.mvvmwithretrofit.Modle.News

class QuotesRepository(private val quoteService: QuoteService) {


    private val quoteLiveDat = MutableLiveData<News>()

    val quotes: LiveData<News>
        get() = quoteLiveDat

    suspend fun getQuotes(category:String,page: Int) {
        val result = quoteService.getQuotes(category,page)
        if (result?.body() != null) {
            quoteLiveDat.postValue(result.body())
        }
    }
}