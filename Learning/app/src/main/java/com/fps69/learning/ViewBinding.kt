package com.fps69.learning

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fps69.learning.databinding.ActivityViewBindingBinding

class ViewBinding : AppCompatActivity() {

    // Yha binding varibale create kr rhe hai
     private lateinit var  binding : ActivityViewBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Yha binding var ko intilize kr rhe hai
        // Iss code ko hmesa binding ko initilize krne ke liye use krte hai
        binding = ActivityViewBindingBinding.inflate(layoutInflater)
        // Agr view binding use kr rhe hai to niche setContentView me yhi code likhna hoga
        setContentView(binding.root)


        // View binding use krne se yha hame new variable nhi banana pda
        binding.btnbinding.setOnClickListener {

            if(binding.cbbinding.isChecked){
                val intent= Intent(this,DialogueBoxes::class.java)
                startActivity(intent)
            }else{
                // Yha Cheackbox tick nhi hone pe toast ke sath uska colour change kr rhe hai
                binding.cbbinding.buttonTintList= ColorStateList.valueOf(Color.RED)
                Toast.makeText(this, " Please accept T&C ",Toast.LENGTH_SHORT).show()
            }

        }
    }
}