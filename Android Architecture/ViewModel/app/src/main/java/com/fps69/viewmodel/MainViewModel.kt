package com.fps69.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    var count : Int =0;

    fun Increament(){
        count++
    }

}