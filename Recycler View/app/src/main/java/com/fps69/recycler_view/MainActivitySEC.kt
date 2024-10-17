package com.fps69.recycler_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fps69.recycler_view.databinding.ActivityMainSecBinding

class MainActivitySEC : AppCompatActivity() {

    private lateinit var binding :ActivityMainSecBinding
    private  var resturentList : List<UserDataClassSEC> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainSecBinding.inflate(layoutInflater)
        setContentView(binding.root)


        fetchData()
        initRecyclerView()
    }


    private fun initRecyclerView(){
        binding.RvResturent.apply {
            layoutManager= LinearLayoutManager(this@MainActivitySEC)
            hasFixedSize()
            adapter=MyAdaptersec(resturentList)

        }
    }

    private fun fetchData(){

        resturentList= listOf(
            UserDataClassSEC(
                name = "Classic Margherita Pizza ",
                rating = "4.5",
                prepTime= "prepTimeMinutes :- 45 min",
                cusine = "Italian",
                image = "https://cdn.dummyjson.com/recipe-images/2.webp",
            ),
            UserDataClassSEC(
                name = "Classic Margherita Pizza ",
                rating = "4.5",
                prepTime= "prepTimeMinutes :- 45 min",
                cusine = "Italian",
                image = "https://cdn.dummyjson.com/recipe-images/1.webp",
            ),

            UserDataClassSEC(
                name = "Classic Margherita Pizza ",
                rating = "4.5",
                prepTime= "prepTimeMinutes :- 45 min",
                cusine = "Italian",
                image = "https://cdn.dummyjson.com/recipe-images/3.webp",
            ),
            UserDataClassSEC(
                name = "Classic Margherita Pizza ",
                rating = "4.5",
                prepTime= "prepTimeMinutes :- 45 min",
                cusine = "Italian",
                image = "https://cdn.dummyjson.com/recipe-images/4.webp",
            ),
            UserDataClassSEC(
                name = "Classic Margherita Pizza ",
                rating = "4.5",
                prepTime= "prepTimeMinutes :- 45 min",
                cusine = "Italian",
                image = "https://cdn.dummyjson.com/recipe-images/5.webp",
            ),
            UserDataClassSEC(
                name = "Classic Margherita Pizza ",
                rating = "4.5",
                prepTime= "prepTimeMinutes :- 45 min",
                cusine = "Italian",
                image = "https://cdn.dummyjson.com/recipe-images/6.webp",
            ),
            UserDataClassSEC(
                name = "Classic Margherita Pizza ",
                rating = "4.5",
                prepTime= "prepTimeMinutes :- 45 min",
                cusine = "Italian",
                image = "https://cdn.dummyjson.com/recipe-images/7.webp",
            ),
            UserDataClassSEC(
                name = "Classic Margherita Pizza ",
                rating = "4.5",
                prepTime= "prepTimeMinutes :- 45 min",
                cusine = "Italian",
                image = "https://cdn.dummyjson.com/recipe-images/8.webp",
            ),
            UserDataClassSEC(
                name = "Classic Margherita Pizza ",
                rating = "4.5",
                prepTime= "prepTimeMinutes :- 45 min",
                cusine = "Italian",
                image = "https://cdn.dummyjson.com/recipe-images/9.webp",
            ),
            UserDataClassSEC(
                name = "Classic Margherita Pizza ",
                rating = "4.5",
                prepTime= "prepTimeMinutes :- 45 min",
                cusine = "Italian",
                image = "https://cdn.dummyjson.com/recipe-images/10.webp",
            ),
            UserDataClassSEC(
                name = "Classic Margherita Pizza ",
                rating = "4.5",
                prepTime= "prepTimeMinutes :- 45 min",
                cusine = "Italian",
                image = "https://cdn.dummyjson.com/recipe-images/11.webp",
            ),
            UserDataClassSEC(
                name = "Classic Margherita Pizza ",
                rating = "4.5",
                prepTime= "prepTimeMinutes :- 45 min",
                cusine = "Italian",
                image = "https://cdn.dummyjson.com/recipe-images/12.webp",
            ),
            UserDataClassSEC(
                name = "Classic Margherita Pizza ",
                rating = "4.5",
                prepTime= "prepTimeMinutes :- 45 min",
                cusine = "Italian",
                image = "https://cdn.dummyjson.com/recipe-images/13.webp",
            ),
            UserDataClassSEC(
                name = "Classic Margherita Pizza ",
                rating = "4.5",
                prepTime= "prepTimeMinutes :- 45 min",
                cusine = "Italian",
                image = "https://cdn.dummyjson.com/recipe-images/14.webp",
            )
        )

    }
}