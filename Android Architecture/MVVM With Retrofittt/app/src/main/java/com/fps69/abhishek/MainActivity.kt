package com.fps69.abhishek

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fps69.abhishek.api.QuoteService
import com.fps69.abhishek.api.RetrofitBuilder
import com.fps69.abhishek.repository.QuotesRepository
import com.fps69.abhishek.viewModel.MainViewModel
import com.fps69.abhishek.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {



    private lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quotesService = RetrofitBuilder.getInstance().create(QuoteService::class.java)
        val quotesRepository = QuotesRepository(quotesService)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(quotesRepository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {
            Log.d("AbhishekSuman", it.toString())
        })
    }
}