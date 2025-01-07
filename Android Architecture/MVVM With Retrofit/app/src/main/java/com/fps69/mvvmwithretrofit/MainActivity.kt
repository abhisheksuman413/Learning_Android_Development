package com.fps69.mvvmwithretrofit

import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fps69.mvvmwithretrofit.Api.QuoteService
import com.fps69.mvvmwithretrofit.Api.RetrofitHelper
import com.fps69.mvvmwithretrofit.Repository.QuotesRepository
import com.fps69.mvvmwithretrofit.ViewModel.MainViewModel
import com.fps69.mvvmwithretrofit.ViewModel.MainViewModelFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {


//    private lateinit var binding: ActivityMainBinding
    private lateinit var mainVieModel : MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = DataBindingUtil.
        setContentView(R.layout.activity_main)


        val repository = (application as NewsApplication).newsRepository

        mainVieModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)



        mainVieModel.quotes.observe(this, Observer {
            Log.d("abhi", it.toString())
        })

    }
}