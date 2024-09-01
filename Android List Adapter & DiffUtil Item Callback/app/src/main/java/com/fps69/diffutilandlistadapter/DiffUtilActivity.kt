package com.fps69.diffutilandlistadapter

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.fps69.diffutilandlistadapter.Addapter.DiffUtilAdapter
import com.fps69.diffutilandlistadapter.DataClass.User
import com.fps69.diffutilandlistadapter.databinding.ActivityDiffutilBinding

class DiffUtilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDiffutilBinding

    private lateinit var diffUtilAdapter: DiffUtilAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiffutilBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val p1 = User(userName="Abhishek Suman")
        val p2 = User(userName="Rohit")
        val p3 = User(userName="Nitish")
        val p4 = User(userName="Aaditee")

        diffUtilAdapter = DiffUtilAdapter()
        binding.rvEmployeeList.apply {
            layoutManager= LinearLayoutManager(this@DiffUtilActivity,LinearLayoutManager.VERTICAL,false)
            adapter= diffUtilAdapter
        }
        diffUtilAdapter.differ.submitList(listOf(p1,p2,p3,p4))



        // Yha 5 sec ke bad list ko update kr de rhe hai
        Handler(Looper.getMainLooper()).postDelayed({
            val p2 = User(userName="Rohit")
            val p5 = User(userName="Pankaj")
            val p6 = User(userName="Ram")
            diffUtilAdapter.differ.submitList(listOf(p2,p5,p6))
        },5000)


    }
}