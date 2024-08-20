package com.fps69.kotlincoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fps69.kotlincoroutine.databinding.ActivitySuspendFunctionBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

class SuspendFunctionActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySuspendFunctionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivitySuspendFunctionBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.apply {
            BTN1CoroutineSuspendingFunction.setOnClickListener {

                // launching Coroutine
                CoroutineScope(Dispatchers.Main).launch {
                    task1()
                }
                CoroutineScope(Dispatchers.Main).launch {
                    task2()
                }
            }
        }


    }

    suspend fun task1() {
        Log.d("cheack","Thread name :- ${Thread.currentThread().name} :- Starting Task 1 ")
        yield() // yield() is a builtin functions in kotlin coroutine library it helps to define suspension point in function
               // yield() is also a suspending function
        Log.d("cheack","Thread name :- ${Thread.currentThread().name} :- Ending Task 1 ")

    }

    suspend fun task2() {
        Log.d("cheack","Thread name :- ${Thread.currentThread().name} :- Starting Task 2")
        delay(10000) // delay() Work as same as yield() function  
        Log.d("cheack","Thread name :- ${Thread.currentThread().name} :- Ending Task 2 ")
    }
}