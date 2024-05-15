package com.fps69.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("recipes")
    fun getProductData(): Call<UserDataClass>
}