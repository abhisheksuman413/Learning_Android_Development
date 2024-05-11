package com.fps69.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PassDataSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pass_data_second)

        //Yha intent me getintent select kr rhe hai

        val orderofCustomer = intent.getStringExtra(PassDtatinActivity.KEY)
        val textview_order = findViewById<TextView>(R.id.tvorder)
        // Yha customer odder ko textview me set kr rhe hai
        textview_order.text = orderofCustomer
    }
}