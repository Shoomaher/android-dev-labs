package com.example.lab2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    //Just to detect this app
    val REQUEST_CODE = 120

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val coronaVirusDetected: Button = findViewById<Button>(R.id.coronaVirusDetectedBtn)

        coronaVirusDetected.setOnClickListener {
            val intent = Intent(this, CoronaVirusDetectedActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_CANCELED) {
                // For lucky ones
                val appHeader:TextView = findViewById<TextView>(R.id.activityHeader)
                appHeader.text = getString(R.string.persistent_user_text)
            }
        }
    }
}
