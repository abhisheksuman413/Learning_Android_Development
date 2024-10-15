package com.fps69.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    val quoteLiveData = MutableLiveData("Original live data Abhishek Suman")

    fun updateQuote(){
        quoteLiveData.value = "Live Data Updated to Suman JIIII"
    }
}