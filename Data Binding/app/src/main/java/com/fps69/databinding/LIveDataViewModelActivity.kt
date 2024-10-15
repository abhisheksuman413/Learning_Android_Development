package com.fps69.databinding

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fps69.databinding.databinding.ActivityLiveDataViewModelBinding

class LIveDataViewModelActivity : AppCompatActivity() {

    private  lateinit var  binding: ActivityLiveDataViewModelBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_live_data_view_model)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.mainViewModel=mainViewModel
        binding.lifecycleOwner = this

        binding.BTNTwoWayBinding.setOnClickListener {
            startActivity(Intent(this@LIveDataViewModelActivity, TwoWayActivity::class.java))
        }

//        Isko ab xml me set kr rhe hai
//        binding.BTNUpdateFacts.setOnClickListener {
//            mainViewModel.updateQuote()
//        }

    }
}