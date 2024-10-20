package com.fps69.androidmvvmarchitecture.Repository

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import com.fps69.androidmvvmarchitecture.Room.Quote
import com.fps69.androidmvvmarchitecture.Room.QuoteDao


class QuoteRepository(private val quoteDao : QuoteDao) {



    fun getQuotes() : LiveData<List<Quote>>{
        return quoteDao.getQuotes()
    }



    suspend fun insertQuote(quote : Quote){
        quoteDao.insertQuote(quote)
    }

}