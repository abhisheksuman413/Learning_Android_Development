package com.fps69.livedata

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fps69.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private  lateinit var binding : ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel= ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.count.observe(this, Observer {
            binding.textView.text = it.toString()
        })


        // Change in Data
        binding.apply {
            BTNIncrease.setOnClickListener {
                mainViewModel.increaseCount()
            }

            BTNDecrease.setOnClickListener {
                mainViewModel.decreaseCount()
            }

        }



    }
}