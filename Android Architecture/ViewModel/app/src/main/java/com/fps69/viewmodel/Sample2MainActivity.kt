package com.fps69.viewmodel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.fps69.viewmodel.databinding.ActivitySample2MainBinding

class Sample2MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivitySample2MainBinding

    lateinit var mainViewModel: MainViewModel2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySample2MainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mainViewModel=ViewModelProvider(this@Sample2MainActivity,MainViewModel2Factory(10)).get(MainViewModel2::class.java)



        binding.apply {
            BTN1.setOnClickListener {
                mainViewModel.Increament()
                setText()
            }
            TV1.text = mainViewModel.count.toString()
        }
    }

    private fun setText() {
        binding.TV1.text = mainViewModel.count.toString()
    }
}