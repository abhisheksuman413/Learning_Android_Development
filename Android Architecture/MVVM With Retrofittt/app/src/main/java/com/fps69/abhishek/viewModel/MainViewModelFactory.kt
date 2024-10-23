package com.fps69.abhishek.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fps69.abhishek.repository.QuotesRepository

class MainViewModelFactory(private val quotesRepository: QuotesRepository) : ViewModelProvider.Factory{


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(quotesRepository) as T
    }
}