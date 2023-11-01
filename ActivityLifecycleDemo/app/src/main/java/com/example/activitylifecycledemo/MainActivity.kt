package com.example.activitylifecycledemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("MyTag", "MainActivity: onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val greetingTextView = findViewById<TextView>(R.id.tvHello)
        val inputField = findViewById<EditText>(R.id.etName)
        val submitButton = findViewById<Button>(R.id.btnSubmit)
        val offersButton = findViewById<Button>(R.id.btnOffers)
        var enteredName = ""
        submitButton.setOnClickListener {
            enteredName = inputField.text.toString()
            if (enteredName == ""){
                offersButton.visibility = View.INVISIBLE
                greetingTextView.text = ""
                Toast.makeText(
                    this@MainActivity,
                    "Please, enter your name!",
                    Toast.LENGTH_SHORT
                ).show()
            }else {
                val message = "Welcome $enteredName"
                greetingTextView.text = message
                inputField.text.clear()
                offersButton.visibility = View.VISIBLE
            }
        }

        offersButton.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("USER",enteredName)
            startActivity(intent)
        }


    }
    override fun onStart() {
        super.onStart()
        Log.i("MyTag", "MainActivity: onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MyTag", "MainActivity: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MyTag", "MainActivity: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MyTag", "MainActivity: onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MyTag", "MainActivity: onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MyTag", "MainActivity: onRestart()")
    }
}