package com.fps69.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivityLoginThroughFirebase : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_login_through_firebase)


        val name = intent.getStringExtra(LoginThroughFirebase.KEY2)
        val email = intent.getStringExtra(LoginThroughFirebase.KEY1)
        val id = intent.getStringExtra(LoginThroughFirebase.KEY3)
        val password = intent.getStringExtra(LoginThroughFirebase.KEY4)

        val userDetails=findViewById<TextView>(R.id.tvuserdetails)
        userDetails.text="user id :- $id \n Name :- $name \n Email :- $email \n Password :- $password"
    }
}