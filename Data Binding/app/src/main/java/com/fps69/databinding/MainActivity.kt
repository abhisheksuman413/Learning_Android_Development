package com.fps69.databinding

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.fps69.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        val quoteObj = Quote("Abhishek Suman hai", "Abhishek")
        binding.quote = quoteObj
        binding.BTNNextPageLiveData.setOnClickListener {
            startActivity(Intent(this@MainActivity,LIveDataViewModelActivity::class.java))
        }

    }
}