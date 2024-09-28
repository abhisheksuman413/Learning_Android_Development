package com.fps69.viewmodel

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Inbox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fps69.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var count: Int = 0


    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.apply {
            BTN1.setOnClickListener {
                count++
                SetText()
            }
            BTN2.setOnClickListener {
                startActivity(Intent(this@MainActivity, SampleMainActivity::class.java))
            }
        }

    }

    private fun SetText() {
        binding.TV1.text = count.toString()
    }
}