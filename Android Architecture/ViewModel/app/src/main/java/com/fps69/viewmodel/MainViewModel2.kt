package com.fps69.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel2(val intitialValur: Int) : ViewModel() {

    var count: Int = intitialValur;

    fun Increament() {
        count++
    }
}