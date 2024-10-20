package com.fps69.mvvmwithretrofit.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fps69.mvvmwithretrofit.Api.QuoteService
import com.fps69.mvvmwithretrofit.Modle.QuoteList

class QuotesRepository(private val quoteService: QuoteService) {


    private val quoteLiveDat = MutableLiveData<QuoteList>()

    val quotes: LiveData<QuoteList>
        get() = quoteLiveDat

    suspend fun getQuotes(page: Int) {
        val result = quoteService.getQuotes(page)
        if (result?.body() != null) {
            quoteLiveDat.postValue(result.body())
        }
    }
}