package com.fps69.abhishek.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fps69.abhishek.modle.MovieItem
import com.fps69.abhishek.modle.QuoteList
import com.fps69.abhishek.repository.QuotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val quoteRepository : QuotesRepository) : ViewModel(){



    init {

        viewModelScope.launch(Dispatchers.IO) {
            quoteRepository.getQuotes()
        }
    }


    val quotes : LiveData<List<MovieItem>>
        get() = quoteRepository.quotes

}