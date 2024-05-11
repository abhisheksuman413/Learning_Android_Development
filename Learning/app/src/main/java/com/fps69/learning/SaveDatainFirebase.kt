package com.fps69.learning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SaveDatainFirebase : AppCompatActivity() {

    // For Useing firebase we have to create a varibale of firebase
    // Jiska type of DatabaseReference
    lateinit var database:DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_datain_firebase)

        val signButton = findViewById<Button>(R.id.btnsignup)
        val etName =findViewById<EditText>(R.id.etname)
        val etId =findViewById<EditText>(R.id.etid)
        val etEmail =findViewById<EditText>(R.id.etemail)
        val etPassword=findViewById<EditText>(R.id.etpassword)
        signButton.setOnClickListener {

            val name =etName.text.toString()
            val mail =etEmail.text.toString()
            val id =etId.text.toString()
            val password =etPassword.text.toString()

            val user = UserDataClassForSavedDatainFirebase(name,mail,password,id)
            // Yha database varible me path set kr rhe hai Users tak
            database =FirebaseDatabase.getInstance().getReference("Users")
//          // Yha firebase me value set kr rhe hai
            database.child(id).setValue(user).addOnSuccessListener {
                // Registor krne ke bad fild kom clear kr de rhe hai
                etName.text.clear()
                etEmail.text.clear()
                etId.text.clear()
                etPassword.text.clear()

                Toast.makeText(this,"User Registor  ",Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this,"Faied ",Toast.LENGTH_SHORT).show()

            }
        }


        val loginbutton2 = findViewById<Button>(R.id.btnlogin2)
        loginbutton2.setOnClickListener {
            val new_intent= Intent(this,LoginThroughFirebase::class.java)
            startActivity(new_intent)

        }
    }



}