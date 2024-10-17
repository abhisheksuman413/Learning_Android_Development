package com.fps69.recycler_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fps69.recycler_view.databinding.ActivityNewsDetailsBinding

class NewsDetails : AppCompatActivity() {

    lateinit var binding : ActivityNewsDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val heading = intent.getStringExtra("Heading")
        val newsContent = intent.getStringExtra("newsDetails")
        val imageId = intent.getIntExtra("newsImage", R.drawable.pic1)




        binding.newsContent.text=newsContent
        binding.newsHeading.text=heading
        binding.newsImage.setImageResource(imageId)
    }
}