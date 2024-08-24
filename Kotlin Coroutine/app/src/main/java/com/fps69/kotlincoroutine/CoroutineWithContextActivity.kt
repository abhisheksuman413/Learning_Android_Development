package com.fps69.kotlincoroutine

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fps69.kotlincoroutine.databinding.ActivityCoroutineWithContextBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineWithContextActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCoroutineWithContextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineWithContextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            BTN1.setOnClickListener {
                GlobalScope.launch {
                    execute()
                }
            }
            BTN2.setOnClickListener {
                GlobalScope.launch {
                    execute2()
                }
            }
        }

    }



    private fun execute() {
      Log.d("cheack" , " Before ")
        GlobalScope.launch {
            delay(1000)
            Log.d("cheack" , " Inside ")
        }
        Log.d("cheack" , " After ")
    }

    /*
        * Yha code ase chlega
            1) Before
            2) After
            3) Inside
        >>> Yha launch ruka nhi or aage ka code execute kr diya
        >>> Launch ko hamlog nonblocking v bolte hai
       * */


    private suspend fun execute2() {
        // Coroutine WithContext

        Log.d("cheack" , " Before ")
        withContext(Dispatchers.IO){
            delay(1000)
            Log.d("cheack" , " Inside ")
        }
        Log.d("cheack" , " After ")

        /*
        >>> Coroutine WithContext me coroutine context wala part optional nhi hai hame pass krna hi hoga
        >>> Coroutine WithContext coroutine ko suspend kr dega aage wal Log yha execute nhi hoga
        >>> Yha thread ki blocking nhi hoti hai yha coroutine ki blocking hoti hai 
        * Yha code ase chlega
            1) Before
            2) Inside
            3) After
        * */

    }
}
