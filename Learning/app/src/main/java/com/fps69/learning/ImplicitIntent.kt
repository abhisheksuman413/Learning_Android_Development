package com.fps69.learning

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast

class ImplicitIntent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implict_intent)

// These are the code for intent
// See official document for more
        val cam = findViewById<Button>(R.id.btncam)
        val call_button = findViewById<Button>(R.id.btncall)

        cam.setOnClickListener{
            // yha deside kr rhe hai implicit hai ya explicit intent hai
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }


        call_button.setOnClickListener {
            val phoneNumber:String = "7004822500"
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("phoneNumber")

            if (intent.resolveActivity(packageManager) != null)
            {
                startActivity(intent)

            }else
            {
                Toast.makeText(this, "Phone call not supported on this device", Toast.LENGTH_SHORT).show()
            }
        }




    }
}