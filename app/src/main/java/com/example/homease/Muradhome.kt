package com.example.homease

import android.content.ActivityNotFoundException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class Muradhome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_muradhome)

        val threed = findViewById<Button>(R.id.threeD)
        threed.setOnClickListener {
            val mIntent = packageManager.getLaunchIntentForPackage("com.DefaultCompany.HTL_GVR")
            if (mIntent != null) {
                try {
                    startActivity(mIntent)
                } catch (err: ActivityNotFoundException) {
                    val t = Toast.makeText(applicationContext, "App is not found", Toast.LENGTH_SHORT)
                    t.show()
                }
            }
        }
        val ar = findViewById<Button>(R.id.ar)
        ar.setOnClickListener {
            val mIntent = packageManager.getLaunchIntentForPackage("com.DefaultCompany.HTL_GVR")
            if (mIntent != null) {
                try {
                    startActivity(mIntent)
                } catch (err: ActivityNotFoundException) {
                    val t = Toast.makeText(applicationContext, "App is not found", Toast.LENGTH_SHORT)
                    t.show()
                }
            }
        }
        val vr = findViewById<Button>(R.id.vr)
        vr.setOnClickListener {
            val mIntent = packageManager.getLaunchIntentForPackage("com.DefaultCompany.HTL_GVR")
            if (mIntent != null) {
                try {
                    startActivity(mIntent)
                } catch (err: ActivityNotFoundException) {
                    val t = Toast.makeText(applicationContext, "App is not found", Toast.LENGTH_SHORT)
                    t.show()
                }
            }
        }
    }
}