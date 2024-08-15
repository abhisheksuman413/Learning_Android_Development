package com.fps69.kotlincoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fps69.kotlincoroutine.databinding.ActivityMainThreadsBinding
import kotlin.concurrent.thread

class MainThreadsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainThreadsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainThreadsBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.apply {
            BTN1.setOnClickListener {
                updatecounter()
                Log.d("cheack","${Thread.currentThread().name}")
            }
            BTN2LongTask.setOnClickListener {
                executeLongRuningTask() // This function is used to execute dummy long running task
                                       // By running this function our main threads get block because all task is running on main threads
            }
            BTN3LongTask2.setOnClickListener {
                thread(start = true) {
                    executeLongRuningTask()/*
                                        >>> Yha hamlog new threads created kr rhe hai
                                        >>> Agr yha iss function ko execute krte hai to hmara main threads block nhi hoga or UI update ho jyega
                                        >>> Because ye function yha main threads pe nhi background threads pe run krega */
                }
            }
        }

    }

    private fun executeLongRuningTask() {
        Log.d("cheack","${Thread.currentThread().name}")
        for(i in 1..1000000000L){

        }
    }

    fun updatecounter(){
        Log.d("cheack","${Thread.currentThread().name}")
        binding.TV1.text= "${binding.TV1.text.toString().toInt()+1}"
    }
}