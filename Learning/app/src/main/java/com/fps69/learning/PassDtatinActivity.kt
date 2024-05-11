package com.fps69.learning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class PassDtatinActivity : AppCompatActivity() {

    // Creating Key
    companion object {
        const val  KEY = "com.fps69.learning.PassDtatinActivity.KEY"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pass_dtatin)

        val order_one=findViewById<EditText>(R.id.et1)
        val order_two=findViewById<EditText>(R.id.et2)
        val order_three=findViewById<EditText>(R.id.et3)
        val order_button = findViewById<Button>(R.id.btnorder)


        order_button.setOnClickListener {
            // Yha array list ya koi or contaioner bna kr data pass kr skte hai
            val order_list = order_one.text.toString()+ " "+order_two.text.toString()+" "+order_three.text.toString()

            val intent =Intent(this,PassDataSecondActivity::class.java)
            intent.putExtra(KEY,order_list)
            startActivity(intent)
        }


    }
}