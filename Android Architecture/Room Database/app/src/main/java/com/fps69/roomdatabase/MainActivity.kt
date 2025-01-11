package com.fps69.roomdatabase

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.Observer

import com.fps69.roomdatabase.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var dtabase: ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // We use singleton object instead of using this code
//        dtabase = Room.databaseBuilder(applicationContext,
//            ContactDatabase::class.java,
//            "contactDB"
//        ).build()

        // Uper wale code ke place pe


        dtabase = ContactDatabase.getDatabase(this)

        GlobalScope.launch {
            dtabase.contactDao().insertFunction(Contact(0, "Abhishek", "7004822500", Date(),0))
        }


        binding.main.setOnClickListener {

            dtabase.contactDao().getContact().observe(this, Observer {
                Log.d("Abhishek", it.toString())
            })
        }


    }
}