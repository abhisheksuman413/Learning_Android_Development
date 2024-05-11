package com.fps69.learning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LoginThroughFirebase : AppCompatActivity() {

    companion object {
        const val  KEY1 = "com.fps69.learning.LoginThroughFirebase.mail"
        const val  KEY2 = "com.fps69.learning.LoginThroughFirebase.name"
        const val  KEY3 = "com.fps69.learning.LoginThroughFirebase.id"
        const val  KEY4 = "com.fps69.learning.LoginThroughFirebase.password"

    }


    lateinit var  database:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_through_firebase)

        val btnlogin = findViewById<Button>(R.id.btnlogin)
        val loginemail = findViewById<EditText>(R.id.etloginemail)

        btnlogin.setOnClickListener {

            val loginemailString = loginemail.text.toString()
            if(loginemailString.isNotEmpty()){
                readData(loginemailString)
            }
            else{
                Toast.makeText(this, "Email not present",Toast.LENGTH_SHORT).show()
            }

        }


    }// >>> Oncreate method over

    private fun readData(emailidforlogin:String){
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(emailidforlogin).get().addOnSuccessListener {
            if(it.exists()){
//                // Move to new page and pass data
                val id = it.child("id").value
                val name = it.child("name").value
                val email = it.child("email").value
                val password = it.child("password").value


                val intent = Intent(this,SecondActivityLoginThroughFirebase::class.java)
                intent.putExtra(KEY1, email.toString())
                intent.putExtra(KEY2, name.toString())
                intent.putExtra(KEY3, id.toString())
                intent.putExtra(KEY4, password.toString())
                startActivity(intent)
            }else{
                Toast.makeText(this, "User not exits ",Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener {
            Toast.makeText(this, "Error occure   ",Toast.LENGTH_SHORT).show()
        }
    }
}