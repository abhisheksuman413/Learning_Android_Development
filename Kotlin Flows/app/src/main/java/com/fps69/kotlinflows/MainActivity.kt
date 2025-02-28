package com.fps69.kotlinflows

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        GlobalScope.launch {
            procucer().collect{
                Log.d("Abhi", "Data :-  ${it.toString()}")
            }
        }

    }



     fun procucer( ) = flow<Int> {
         val list = listOf(1,2,3,4,5,6,7,8,9)
         list.forEach {
             delay(10000)
             emit(it)
         }
     }
}