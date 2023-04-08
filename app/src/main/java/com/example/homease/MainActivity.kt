package com.example.homease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit = findViewById<TextView>(R.id.editProfile)
        edit.setOnClickListener {
            val intent = Intent(this, profile::class.java)
            startActivity(intent)
        }

            val add = findViewById<Button>(R.id.add_btn)
            add.setOnClickListener {
                val intent = Intent(this,ownerPage::class.java)
                startActivity(intent)
            }

    }
}