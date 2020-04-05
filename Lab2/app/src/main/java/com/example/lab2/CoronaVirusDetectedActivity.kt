package com.example.lab2

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class CoronaVirusDetectedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corona_virus_detected)

        val makeWillBtn = findViewById<Button>(R.id.MakeWillBtn)

        makeWillBtn.setOnClickListener {
            val sendWill = Intent(Intent.ACTION_SEND)
            sendWill.setType("text/plain")
            sendWill.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.will_header))
            sendWill.putExtra(Intent.EXTRA_TEXT, getString(R.string.will_template))
            startActivity(sendWill)

            val manager:PackageManager = this.packageManager
            val list:List<ResolveInfo> = manager.queryIntentActivities(sendWill, 0)
            if (list.isNotEmpty())
               startActivity(sendWill)
            else
                Toast.makeText(this, R.string.unable_create_will, Toast.LENGTH_SHORT).show()
        }

        var backBtnClicks = 0
        val goBackBtn = findViewById<Button>(R.id.GoBackBtn)
        goBackBtn.setOnClickListener {
            Toast.makeText(this, R.string.no_way_back_text, Toast.LENGTH_SHORT).show()
            backBtnClicks++
            if (backBtnClicks > 5) {
                setResult(Activity.RESULT_CANCELED)
                finish()
            }
        }
    }

    override fun onBackPressed() {
        Toast.makeText(this, R.string.no_way_dude_text, Toast.LENGTH_SHORT).show()
    }
}
