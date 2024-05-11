package com.fps69.learning

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.fps69.learning.databinding.ActivityDialogueBoxesBinding

class DialogueBoxes : AppCompatActivity() {

    lateinit var  binding : ActivityDialogueBoxesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityDialogueBoxesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Niche hamlog alert dialogue box bna rhe hai
        binding.btndb1.setOnClickListener {
            // Yha eak AlertDialog class ka variable bna rhe hai usaka context this de rhe hai
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle(" Are you sure ")  // >>> Title set kr rhe hai
            builder1.setMessage(" Do you want to close aap ") // >>> Yha message set kr rhe hai
            builder1.setIcon(R.drawable.baseline_close_24) // Yha icon set kr rhe hai
            builder1.setPositiveButton("yes ",DialogInterface.OnClickListener { dialogInterface, i ->
                // Jo action ham niche likhte hai wo hoga
                // Because ye lamda function hai or niche uska return type hai
                finish()

            })
            builder1.setNegativeButton("NO ",DialogInterface.OnClickListener { dialogInterface, i ->
                // Jo action ham niche likhte hai wo hoga
                // Because ye lamda function hai or niche uska return type hai
                val intent = Intent(this,LoginThroughFirebase::class.java)
                startActivity(intent)
            })
            builder1.show() // Jo alert dialogue box bnaye hai usko show kr rhe hai


        }
        binding.btndb2.setOnClickListener{

            val option = arrayOf(" ravi ", "Shyam", "Ram", "Sita ", "Gita", "Nitish")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle(" Are you sure ")  // >>> Title set kr rhe hai
            builder2.setIcon(R.drawable.baseline_close_24) // Yha icon set kr rhe hai


            // Niche wale code se hamlog single chioce ka option show kr rhe hai or select v kr rhe hai
            builder2.setSingleChoiceItems(option,0,DialogInterface.OnClickListener { dialogInterface, i ->
                // Niche jo code likhge wo hoga
                // Yha i me wo value aa rha jo item ham select kr rhe hai uska array index
                Toast.makeText(this," You clicked on ${option[i]}",Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Accepted ",DialogInterface.OnClickListener { dialogInterface, i ->
                // Jo action ham niche likhte hai wo hoga
                // Because ye lamda function hai or niche uska return type hai
                finish()

            })
            builder2.setNegativeButton("NO ",DialogInterface.OnClickListener { dialogInterface, i ->
                // Jo action ham niche likhte hai wo hoga
                // Because ye lamda function hai or niche uska return type hai
                val intent = Intent(this,LoginThroughFirebase::class.java)
                startActivity(intent)
            })
            builder2.show() // Jo alert dialogue box bnaye hai usko show kr rhe hai

        }
        binding.btndb3.setOnClickListener{

            val option = arrayOf(" ravi ", "Shyam", "Ram", "Sita ", "Gita", "Nitish")
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle(" Are you sure ")  // >>> Title set kr rhe hai
            builder3.setIcon(R.drawable.baseline_close_24) // Yha icon set kr rhe hai


            // Niche wale code se hamlog multiple chioce ka option show kr rhe hai or select v kr rhe hai

            builder3.setMultiChoiceItems(option,null,DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->
                // Niche jo code likhge wo hoga
                // Yha i me wo value aa rha jo item ham select kr rhe hai uska array index
                // yha b me Boolean value aa rha hai jo item ham select kr rhe hai wo phle se selected hai ya nhi
                Toast.makeText(this," You clicked on ${option[i]} and ${b}",Toast.LENGTH_SHORT).show()
            })


            builder3.setPositiveButton("Accepted ",DialogInterface.OnClickListener { dialogInterface, i ->
                // Jo action ham niche likhte hai wo hoga
                // Because ye lamda function hai or niche uska return type hai
                finish()

            })
            builder3.setNegativeButton("NO ",DialogInterface.OnClickListener { dialogInterface, i ->
                // Jo action ham niche likhte hai wo hoga
                // Because ye lamda function hai or niche uska return type hai
                val intent = Intent(this,LoginThroughFirebase::class.java)
                startActivity(intent)
            })
            builder3.show() // Jo alert dialogue box bnaye hai usko show kr rhe hai

        }

    }
}