package com.fps69.mvvmwithretrofit.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fps69.mvvmwithretrofit.Modle.News
import com.fps69.mvvmwithretrofit.Repository.QuotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel( private val repository : QuotesRepository)  : ViewModel() {



    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes("business",1)
        }
    }


    val quotes : LiveData<News>
        get() = repository.quotes
}