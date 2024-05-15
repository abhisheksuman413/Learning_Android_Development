package com.fps69.myapplication

data class UserDataClass(
    val limit: Int,
    val recipes: List<Recipe>,
    val skip: Int,
    val total: Int
)