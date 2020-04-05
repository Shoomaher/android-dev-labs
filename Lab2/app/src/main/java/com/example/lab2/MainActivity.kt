package com.example.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val coronaVirusDetected: Button = findViewById<Button>(R.id.coronaVirusDetectedBtn)

        coronaVirusDetected.setOnClickListener {
            val intent = Intent(this, CoronaVirusDetectedActivity::class.java)
            startActivity(intent)
        }
    }
}
