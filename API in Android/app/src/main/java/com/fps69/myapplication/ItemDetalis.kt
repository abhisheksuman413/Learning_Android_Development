package com.fps69.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.fps69.myapplication.databinding.ActivityItemDetalisBinding

class ItemDetalis : AppCompatActivity() {
    lateinit var binding:ActivityItemDetalisBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityItemDetalisBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val nameText = intent.getStringExtra("name")
        val ratingText = intent.getStringExtra("rating")
        val imageText = intent.getStringExtra("image")
        val prepTimeMinutesText = intent.getStringExtra("prepTimeMinutes")
        val cuisineText = intent.getStringExtra("cuisine")
        val cookTimeMinutesText = intent.getStringExtra("cookTimeMinutes")
        val difficultyText = intent.getStringExtra("difficulty")
        val servingsText = intent.getStringExtra("servings")
        val caloriesPerServingText = intent.getStringExtra("caloriesPerServing")
        val ingredients = intent.getStringArrayListExtra("ingredients")
        val instructions = intent.getStringArrayListExtra("instructions")



        Glide.with(this).load(imageText).into(binding.ImageBanner)
        binding.apply {
            name.text="Name :- $nameText"
            prepTimeMinutes.text="PrepTimeMinutes :- $prepTimeMinutesText"
            caloriesPerServing.text="CaloriesPerServing :- $caloriesPerServingText"
            cuisine.text="Cuisine :- $cuisineText"
            difficulty.text="Difficulty :- $difficultyText"
            servings.text="Servings :- $servingsText"
            cookTimeMinutes.text="CookTimeMinutes :- $cookTimeMinutesText"

        }
        binding.ingredients.text="Ingredients :- \n >>> " + ingredients!!.joinToString(separator = "\n >>> ")
        binding.instructions.text="Instructions :- \n >>> "+ instructions!!.joinToString(separator = "\n >>> ")




    }
}