package com.fps69.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fps69.learning.databinding.ActivityListViewCustomAdapterBinding

class ListViewCustomAdapter : AppCompatActivity() {

    private lateinit var binding:ActivityListViewCustomAdapterBinding

    lateinit var userarraylist: ArrayList<UserDataClassForListViewCustomAdapter>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewCustomAdapterBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val name = arrayOf("Saumya", "Prastuti", "Ankit", "Pradeep", "Aman")

        val lastMsg = arrayOf("Hey everyone", "I am fine", "Good", "Awesome", "cool")

        val lastMsgTime = arrayOf("6:25 AM", "7:30 PM", "5:00 PM", "6:25 AM", "7:30 PM")

        val phoneNumber = arrayOf("786453739", "986453739", "7366382829", "7383413440", "4159251517")

        val imgId = intArrayOf(R.drawable.pic5, R.drawable.pic1, R.drawable.pic2,
            R.drawable.abhi, R.drawable.pic4)

        userarraylist =ArrayList()
        // Sara value userarraylist me dal rhe hai
        for(item in name.indices){
            val user = UserDataClassForListViewCustomAdapter(name[item],lastMsg[item],lastMsgTime[item],phoneNumber[item],imgId[item])
            userarraylist.add(user)
        }
        
        binding.listView.isClickable=true
        binding.listView.adapter = MyAdapterForListViewCustomAdapter(this,userarraylist)





    }
}