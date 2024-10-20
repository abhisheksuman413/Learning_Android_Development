package com.fps69.androidmvvmarchitecture

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fps69.androidmvvmarchitecture.Repository.QuoteRepository
import com.fps69.androidmvvmarchitecture.Room.Quote
import com.fps69.androidmvvmarchitecture.Room.QuoteDao
import com.fps69.androidmvvmarchitecture.Room.QuoteDatabase
import com.fps69.androidmvvmarchitecture.ViewModel.MainVIewModelFactory
import com.fps69.androidmvvmarchitecture.ViewModel.MainVieModel
import com.fps69.androidmvvmarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel : MainVieModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)



        val Dao = QuoteDatabase.getDatabase(applicationContext).quoteDao()
        val repository = QuoteRepository(Dao)
        mainViewModel = ViewModelProvider(this, MainVIewModelFactory(repository)).get(MainVieModel::class.java)



        mainViewModel.getQuotes().observe(this , Observer {
            binding.quote = it.toString()
        })




        binding.BTNAddQuote.setOnClickListener {

            val quote = Quote(0, " This is testing ", "Abhishek Suman")

            mainViewModel.insertQuote(quote)

        }

    }
}