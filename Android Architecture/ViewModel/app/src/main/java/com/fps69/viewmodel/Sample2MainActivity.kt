package com.fps69.viewmodel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fps69.viewmodel.databinding.ActivitySample2MainBinding

class Sample2MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivitySample2MainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySample2MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}