package com.fps69.kotlincoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fps69.kotlincoroutine.databinding.ActivityCoroutineBuildersBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.annotations.Async

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
            BTN1CoroutineLaunchFunction.setOnClickListener {
                val job = CoroutineScope(Dispatchers.IO).launch { // yha job object ko job me store kr rhe hai
                    // ISs job se hmlog coroutine ko manage kr skte hai

                    printFollowersWithLaunchFunction()
                }

    //        job.cancel()  // iss se hamlog coroutine ko cancel kr skte hai
    //        job.join()   // Jb tak coroutine complete nhi ho jta hai ye function uss coroutine ko waiting state me rakhega

            }
            BTN2CoroutineAcyncFunction.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    printFollowersWithAsyncFunction()
                }
            }
            BTN3PrintFollowers.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    printFollowers()
                }
            }
        }

    }




    private suspend fun printFollowersWithLaunchFunction() {
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
        Log.d("cheack", "Launch Function Run ${fbFollowers.toString()}")

    }


    // Join() ka use n kr ke ase v kr skte hai uss task ko
    private suspend fun printFollowersWithAsyncFunction() {
        val job = CoroutineScope(Dispatchers.IO).async {
            getFbFollowers()
        }//  Deferred<Int> is ka dataType hai
        Log.d("cheack", "Async Function Run ${job.await().toString()}") // await() v suspending Function hai
    }


    private suspend fun printFollowers() {

        /*
        // This is by using Launch Function
        var fbFollowers =0
        var instaFollowers =0
        val job1 = CoroutineScope(Dispatchers.IO).launch {
            fbFollowers=getFbFollowers()
        }
        val job2 = CoroutineScope(Dispatchers.IO).launch {
            instaFollowers=getInstaFollowers()
        }
        job1.join() // Jb Tak job1 execute nhi ho jata tb tak job2 ko execute nhi krega
        job2.join() // Jb Tak job2 execute nhi ho jata tb tak Log ko execute nhi krega

        // Jb tak job1 and job2 execute nhi ho jata tb tak Log ko execute nhi krega
        Log.d("cheack", "With Launch Function fbFollowers $fbFollowers instaFollowers $instaFollowers")

         */

        /*
        // This is by using Async Function
        val job1 = CoroutineScope(Dispatchers.IO).async {
            getFbFollowers()
        }
        val job2 = CoroutineScope(Dispatchers.IO).async {
            getInstaFollowers()
        }

        // Yha job1 and job2 parallel execute ho rhe hai eak hi time pe

        Log.d("cheack", "With Async Function fbFollowers ${job1.await()} instaFollowers ${job2.await()}") // Ye suspending function hai because yha await() ka use kr rhe hai
        // jb tak job1 and job2 execute nhi ho jata tb tak Log ko execute nhi krega
        */

        /*

        CoroutineScope(Dispatchers.IO).launch {
            var fb =getFbFollowers()  //(Suppose it take 1 sec )
            var insta = getInstaFollowers()  //(Suppose it take 1 sec )
            Log.d("cheack", "With Launch Function fbFollowers $fb instaFollowers $insta")
            // Jb tak var fb execute nhi ho jata tb tak var insta execute nhi hoga(Suppose it take 1 sec )
            // Jb tak var insta execute nhi ho jata tb tak Log ko execute nhi krega(Suppose it take 1 sec )
            // To is pure operation me time 2 sec leta hai because jb tak var fb execute nhi ho jata tb tak var insta execute nhi hoga
            // So Fb and insta dono call independent hai
            // So n isko ham parallel execute kr skte hai
            // or Log tb hi execute hoga jb dono call complete ho jayegi
        }

         */

        CoroutineScope(Dispatchers.IO).launch {
            var fb = async { getFbFollowers() } // (Suppose it take 1 sec )
            var insta = async { getInstaFollowers() } //(Suppose it take 1 sec )
            Log.d("cheack", "With Async Function fbFollowers ${fb.await()} instaFollowers ${insta.await()}")

            // Yha pe fb and insta dono call parallel run ho rhe hai
            // jb tak dono call nhi hota tb tak Log ko execute nhi krega
            // tp iss pure operation me time 1 sec leta hai because yha fb and insta dono call parallel ho rhe hai
            // Isliy ye better hai compare to launch function
        }

    }




    // Niche wala function API ko mimic krega (dummy suspended function)
    private suspend fun getFbFollowers():Int{
        delay(10000)
        return 65
    }
    private suspend fun getInstaFollowers(): Int {
        delay(1000)
        return 55
    }
}