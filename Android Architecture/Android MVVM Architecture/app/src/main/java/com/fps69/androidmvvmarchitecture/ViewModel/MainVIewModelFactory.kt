package com.fps69.androidmvvmarchitecture.ViewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fps69.androidmvvmarchitecture.Repository.QuoteRepository

class MainVIewModelFactory(private val quoteRepository: QuoteRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainVieModel(quoteRepository) as T
    }
}