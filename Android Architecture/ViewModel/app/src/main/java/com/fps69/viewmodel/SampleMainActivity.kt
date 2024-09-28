package com.fps69.viewmodel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.fps69.viewmodel.databinding.ActivitySampleMainBinding

class SampleMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySampleMainBinding

    lateinit var mainViewModel: MainViewModel  // Creating object of MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySampleMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mainViewModel = ViewModelProvider(this@SampleMainActivity).get(MainViewModel::class.java)


        binding.apply {
            BTN1.setOnClickListener {
                mainViewModel.Increament()
                SetText()
            }
            TV1.text = mainViewModel.count.toString()


            BTN2.setOnClickListener {
                startActivity(Intent(this@SampleMainActivity, Sample2MainActivity::class.java))
            }
        }

    }

    private fun SetText() {

        binding.TV1.text = mainViewModel.count.toString()
    }
}