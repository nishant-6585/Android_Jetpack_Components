package com.example.coroutinesdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var btnDownloadUserData : Button
    private lateinit var btnCount : Button
    private lateinit var tvCount : TextView
    private lateinit var tvUserMessage : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDownloadUserData = findViewById(R.id.btnDownloadUserData)
        btnCount = findViewById(R.id.btnCount)
        tvCount = findViewById(R.id.tvCount)
        tvUserMessage = findViewById<TextView>(R.id.tvUserMessage)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()

            CoroutineScope(Dispatchers.Main).launch {
                Log.d("MyTag", "Current thread is ${Thread.currentThread().name}" )
            }
        }
        btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                //tvUserMessage.text = UserDataManager().getTotalUserAccount().toString()
                tvUserMessage.text = UserManagerData2().getTotalUserAccount().toString()

            }

        }
    }

    private suspend fun downloadUserData() {
        for (i in 1..200000) {
            withContext(Dispatchers.Main) {
                tvUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}"
                delay(1000)
            }

        }
    }
}