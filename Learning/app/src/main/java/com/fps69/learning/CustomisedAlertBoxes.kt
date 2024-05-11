
package com.fps69.learning

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fps69.learning.databinding.ActivityCustomisedAlertBoxesBinding
import com.fps69.learning.databinding.CustomDialogueBinding

class CustomisedAlertBoxes : AppCompatActivity() {

    lateinit var binding :ActivityCustomisedAlertBoxesBinding
    lateinit var dialog:Dialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomisedAlertBoxesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dialog= Dialog(this)
        val bindingdialog = CustomDialogueBinding.inflate(layoutInflater)
        dialog.setContentView(bindingdialog.root)


        binding.btnCAB.setOnClickListener {
            dialog.show()

        }

        bindingdialog.btnFeedback.setOnClickListener {

            Toast.makeText(this," Feedback collected", Toast.LENGTH_SHORT).show()

        }

        bindingdialog.btnGood.setOnClickListener {
            dialog.dismiss()
        }





    }
}