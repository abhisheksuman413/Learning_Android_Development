package com.fps69.kotlincoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fps69.kotlincoroutine.databinding.ActivityCoroutineBuildersBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineBuildersActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCoroutineBuildersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineBuildersBinding.inflate(layoutInflater)
        setContentView(binding.root)


        CoroutineScope(Dispatchers.IO).launch {
            /*
            * Here launch is a coroutine builder it helps in creating coroutine
            * launch ka return type job hai
            * Ye job se hi coroutine ko manage krte hai
            * coroutine ko cancel krna hai ya coroutine ke liye wait krna hai jb tak coroutine complete
              nhi ho jta hai to isi job object ka use krte hai
            * job object ko store kr skte hai  */
        }



        binding.apply {
            BTN1Coroutine.setOnClickListener {
                val job = CoroutineScope(Dispatchers.IO).launch { // yha job object ko job me store kr rhe hai
                    // ISs job se hmlog coroutine ko manage kr skte hai

                    printFollowers()
                }

    //        job.cancel()  // iss se hamlog coroutine ko cancel kr skte hai
    //        job.join()   // Jb tak coroutine complete nhi ho jta hai ye function uss coroutine ko waiting state me rakhega

            }
        }

    }

    private suspend fun printFollowers() {
        var fbFollowers = 0
        /*
        CoroutineScope(Dispatchers.IO).launch {
            fbFollowers=getFbFollowers()
        }
        Log.d("cheack", fbFollowers.toString())
        >>> Yha pe log me fbFollowers 0 aayega because ye dono parallel me execute ho rha hai
        >>> To yha ham join ka use krege iss se jb tak fbFollowers nhi aa jta tab tak log ko execute nhi krega
        >>> see niche
         */

        val job = CoroutineScope(Dispatchers.IO).launch {
            fbFollowers= getFbFollowers()
        }
        job.join() // Iss function se jb tak fbFollowers nhi aa jta hai tb tak log ko execute nhi krega ye wait krega coroutine end hone ka
                  // job.join() Jb tak coroutine complete nhi ho jta hai ye function uss coroutine ko waiting state me rakhega or aage ka code execute nhi hone dega 
        Log.d("cheack", fbFollowers.toString())

    }


    // Niche wala function API ko mimic krega (dummy suspended function)
    private suspend fun getFbFollowers():Int{
        delay(10000)
        return 55
    }
}