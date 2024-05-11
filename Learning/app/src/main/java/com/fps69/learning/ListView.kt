package com.fps69.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.fps69.learning.databinding.ActivityListViewBinding

class ListView : AppCompatActivity() {
    lateinit var  binding : ActivityListViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Creating array for todolist
        val taskList = arrayListOf<String>()
        taskList.add("Visit CP Hanuman Mandir")
        taskList.add("Attend Exam")
        taskList.add("Complete the App Dev Project")
        taskList.add("Buy bhindi from market")
        taskList.add("Work on resume")
        taskList.add("Improve internet presence")


        // Creating adapter for list view
        val adapterforlist = ArrayAdapter(this,android.R.layout.simple_list_item_1,taskList)
        binding.listView1.adapter=adapterforlist  // yha listviw me adaptor ko set kr rhe hai


        binding.listView1.setOnItemClickListener { parent, view, position, id ->
            val text = "You clicked on " + (view as TextView).text.toString()
            Toast.makeText(this, text , Toast.LENGTH_SHORT).show()
        }


    }
}