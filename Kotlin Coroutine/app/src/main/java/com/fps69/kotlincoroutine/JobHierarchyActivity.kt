package com.fps69.kotlincoroutine

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fps69.kotlincoroutine.databinding.ActivityJobHierarchyBinding
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class JobHierarchyActivity : AppCompatActivity() {

    private lateinit var binding : ActivityJobHierarchyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobHierarchyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            BTN1.setOnClickListener {
                GlobalScope.launch(Dispatchers.Main){
                    execute()
                }
            }
            BTN2.setOnClickListener {
                GlobalScope.launch(Dispatchers.Main){
                    execute2()
                }
            }
            BTN3.setOnClickListener {
                GlobalScope.launch(Dispatchers.Main){
                    execute3()
                }
            }
            BTN4.setOnClickListener {
                GlobalScope.launch(Dispatchers.Main){
                    execute4()
                }
            }
            BTN5.setOnClickListener {
                GlobalScope.launch(Dispatchers.Main){
                    execute5()
                }
            }
            BTN6.setOnClickListener {
                GlobalScope.launch(Dispatchers.Main){
                    execute6()
                }
            }
            BTN7.setOnClickListener {
                GlobalScope.launch(Dispatchers.Main){
                    execute7()
                }
            }
        }

    }




    private fun execute() {
        val parentJob = GlobalScope.launch(Dispatchers.Main){
            Log.d("cheack","Parent Job Started Coroutine context : ${coroutineContext}")

            val childjob1 = launch {
                // Yha hame context define krne ka jarurt nhi hai
                // Because jo context parent ka hota hai wahi context child ka v hota hai
                // Agr context change krna chahe to hame context explicitly define krna hoga
                Log.d("cheack","Child  Job1 Started Coroutine context : ${coroutineContext}")
            }

            val childJob2 = launch(Dispatchers.IO){
                Log.d("cheack","Child  Job2 Started Coroutine context : ${coroutineContext}")
                // Yha context explicitly define krdiya hai
                // Yha context ko override kr rhe hai
            }

        }
    }

    private suspend fun execute2() {
        val parent = GlobalScope.launch(Dispatchers.Main){
            Log.d("cheack", "Parent started ")
            val child = launch {
                Log.d("cheack", "Child started ")
                delay(5000)
                Log.d("cheack", "Child Completed ")
            }
            delay(3000)
            Log.d("cheack", "Parent job completed ") // ye child job complete hone se phle execute hoga because child me delay(5000) hai
        }
        parent.join()
        Log.d("cheack", "Parent Completed ")// ye tb hi execute hoga jb parent ka child coroutine complete hoga

        /*
        * So code ase chlega
            1)Parent started
            2)Child started
            3)Parent job completed
            4)Child Completed
            5)Parent Completed

         */
    }



    private suspend fun execute3() {
        val parent = GlobalScope.launch(Dispatchers.Main){
            Log.d("cheack", "Parent started ")
            val child = launch {
                Log.d("cheack", "Child started ")
                delay(5000)
                Log.d("cheack", "Child Completed ")
            }
            delay(3000)
            Log.d("cheack", "Parent job completed ")
        }
        delay(1000)
        parent.cancel()
        parent.join()
        Log.d("cheack", "Parent Completed ")

        /*
        *  Yha Code ase chlega
        *  1)Parent started
        *  2)Child started
        *  3)Parent completed*


        *  ye hoga because Yha parent.cancel() call hua hai jo ki 1 se wait krne ke bad parent job cancel kr dega
        *  Agr parent job cancel hua to uske jitne child job hoge wo sare cancel hoga
        *  Because yha child me 5 sec ka delay hai or parent ke phle 1 sec ka delay hai  /
         */


    }

    private suspend fun execute4() {
        val parent = GlobalScope.launch(Dispatchers.Main){
            Log.d("cheack", "Parent started ")
            val child = launch {
                Log.d("cheack", "Child started ")
                delay(5000)
                Log.d("cheack", "Child Completed ")
            }
            delay(3000)
            child.cancel()
            Log.d("cheack", "Parent job Ended")
        }

        parent.join()
        Log.d("cheack", "Parent Completed ")
        /*

        *  Yha child job ko manually cancel kr rhe hai
        * Yha code ase chlega
        *  1)Parent started
        *  2)Child started
        *  3)Parent job ended
        *  4)Parent completed

        >>> yha child completed nhi hoga kyuki child job ko cancel kr rhe hai
         */
    }


    private suspend fun execute5() {
        // Jb ham child job ko cancel krte hai to child job coroutine eak exception throw krega jiska name CancellationException hai
        // Or wo CancellationException parent job ke pass jyegi
        // Parent job check krti hai kis type ka exception hai
        // Agr wo CancellationException hai to child coroutine ko cancel kr degi
        // Agr wo CancellationException nhi hai koi or type ka exception hai to pure coroutine(Parent job) cancel hoga
        var parent = GlobalScope.launch(Dispatchers.Main){
            Log.d("cheack", "Parent started ")
            var child = launch (Dispatchers.IO){
                try {
                    Log.d("cheack", "Child started ")
                    delay(5000)
                    Log.d("cheack", "Child Completed ")
                }catch (e:CancellationException){
                    Log.d("cheack", "Child Cancelled ")
                }
            }
            delay(3000)
            child.cancel()
            Log.d("cheack", "Parent job Ended")
        }
        parent.join()
        Log.d("cheack", "Parent Completed ")

        /*
        * Yha code ase chlega
        *  1)Parent started
        *  2)Child started
        *  3)Parent job ended
        *  4)Child Cancelled
        *  5)Parent Completed*/
    }


    private suspend fun execute6() {
        val parentjob = CoroutineScope(Dispatchers.IO).launch {
            for(i in 1..1000){
                ececuteLongRunningTask()
                Log.d("cheack","value of i is $i")
            }
        }
        delay(100)
        Log.d("cheack","Cancelling parent job")
        parentjob.cancel()
        parentjob.join()
        Log.d("cheack","Parent job Completed")
        /*

        >>> Yha ham parent job ko 100 milli second me cancel kr rhe hai
        >>> But hmra coroutine task complete(1000 tak) hone tak chl rha hai
        >>> ParentJob cancel nhi ho rha hai
        >>> Because hamra thread LongRunningTask krne me busy ho gya hai wo check nhi kr rha hai ki hmra coroutine cancel state me hai ya nhi
        >>> Isliye hame khud se check lgana hoga ki hmara coroutine cancel state me hai ya nhi
        >>> Agr cancel ho gya hai to or function execute nhi kruga


        */

    }

    private suspend fun execute7() {

        // Making coroutine cancellable
        // Check lga rhe hai hmra coroutine cancel state me hai ya nhi
        val parentjob = CoroutineScope(Dispatchers.IO).launch {
            for(i in 1..1000){
                if(isActive){
                    ececuteLongRunningTask()
                    Log.d("cheack","value of i is $i")
                }
            }
        }
        delay(100)
        Log.d("cheack","Cancelling parent job")
        parentjob.cancel()
        parentjob.join()
        Log.d("cheack","Parent job Completed")
        
    }


    private fun ececuteLongRunningTask(){
        for(i in 1..10000000){
        }
    }
}