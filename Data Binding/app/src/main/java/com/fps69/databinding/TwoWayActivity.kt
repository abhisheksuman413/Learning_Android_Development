package com.fps69.databinding

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.fps69.databinding.databinding.ActivityTwoWayBinding

class TwoWayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTwoWayBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way)
        mainViewModel= ViewModelProvider(this).get(MainViewModel::class.java)

        binding.mainViewModel=mainViewModel
        binding.lifecycleOwner= this

        binding.BTNBindingAdapters.setOnClickListener {
            startActivity(Intent(this@TwoWayActivity, MainActivity2::class.java))
        }



    }
}