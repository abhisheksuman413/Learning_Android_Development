package com.fps69.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.fps69.myapplication.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        InitRetrofil()


    }

    private fun InitRetrofil(){
        val retrofitBuilder =Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)


        val retrofilData =  retrofitBuilder.getProductData()

        retrofilData.enqueue(object:Callback<UserDataClass?>{
            override fun onResponse(p0: Call<UserDataClass?>, p1: Response<UserDataClass?>) {
                // If Api call is success
                val responseBody =p1.body()
                val productList = responseBody?.recipes!!

                InitRecyclerView(productList)
            }

            override fun onFailure(p0: Call<UserDataClass?>, p2: Throwable) {
                // If API call fails
                Log.d("main Activity ","Error happen"+ p2.message)
            }


        })
    }


    private fun InitRecyclerView( recipes:List<Recipe>){

        binding.RvResturent.apply {
            layoutManager= LinearLayoutManager(this@MainActivity)
            hasFixedSize()
            adapter=MyAdaptor(recipes)

        }

    }
}