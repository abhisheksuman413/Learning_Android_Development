package com.fps69.learning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.fps69.learning.databinding.ActivityExplicitIntentBinding

class ExplicitIntent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_intent)


// Explicit intent is use to move from one screen to another screen Within the the app
        val btnintent = findViewById<Button>(R.id.intent)

        btnintent.setOnClickListener {
            // Open new activity
             intent = Intent(applicationContext,SecondActivityExplicitIntent::class.java)
            startActivity(intent)

        }




    }
}