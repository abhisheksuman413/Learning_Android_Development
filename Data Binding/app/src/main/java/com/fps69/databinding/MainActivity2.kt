package com.fps69.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.fps69.databinding.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding:ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main2)


        val post =DataUser("Abhishek Suman",
            "Abhishek Suman is a good boy",
            "https://firebasestorage.googleapis.com/v0/b/ab-work-manager.appspot.com/o/profile%2FKvw8YWZ78uXvbGA4QnLv7CcaIeC2%2Fprofile.jpg?alt=media&token=509edf80-49af-4502-9b5f-323dfba3bdb8")


        binding.post=post

    }
}