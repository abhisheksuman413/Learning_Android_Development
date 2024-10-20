package com.fps69.androidmvvmarchitecture.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fps69.androidmvvmarchitecture.Repository.QuoteRepository
import com.fps69.androidmvvmarchitecture.Room.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainVieModel(private val quoteRepository: QuoteRepository) : ViewModel() {



    fun getQuotes() : LiveData<List<Quote>>{
        return quoteRepository.getQuotes()
    }


    fun insertQuote( quote : Quote){
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepository.insertQuote(quote)
        }
    }


}