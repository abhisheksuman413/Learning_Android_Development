package com.fps69.learning

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView


/*
// Creating custom adapter for list view

>>> MyAdapterForListViewCustomAdapter iss class ko extend kr rhe hai ArrayAdapter class se
>>> because ham chahte hai sara property use krna ArrayAdapter class ka iss class me
>>> ArrayAdapter ke contructor me 1st :- Context de rhe hai
                                  2nd :- Uss layout ko attach kr rhe jiska hame list view mw use krna hai
                                  3rd :- Jo data ham list view me show kr rhe hai usko de rhe hai (resource)
* */
class MyAdapterForListViewCustomAdapter (val context : Activity,
                                         private val arraylist:ArrayList<UserDataClassForListViewCustomAdapter> ):
    ArrayAdapter<UserDataClassForListViewCustomAdapter>(context,R.layout.each_item_for_custom_adapter,arraylist){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflator = LayoutInflater.from(context)
        val view = inflator.inflate(R.layout.each_item_for_custom_adapter,null)

        val image = view.findViewById<CircleImageView>(R.id.profile_image1)
        val name = view.findViewById<TextView>(R.id.tVName1)
        val lastMsg = view.findViewById<TextView>(R.id.tVLastMessage1)
        val lastMsgTime = view.findViewById<TextView>(R.id.tVLastMsgTime1)
        name.text= arraylist[position].name
        lastMsg.text=arraylist[position].lastMsg
        lastMsgTime.text=arraylist[position].lastMsgTime
        image.setImageResource(arraylist[position].imageid)
        return view
    }




}