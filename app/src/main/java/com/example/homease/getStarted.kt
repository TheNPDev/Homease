package com.example.homease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView

class getStarted : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        val tenant = findViewById<CardView>(R.id.asTenant)
        tenant.setOnClickListener {
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }

        val owner = findViewById<CardView>(R.id.asOwner)
        owner.setOnClickListener {
            val intent = Intent(this, own_login::class.java)
            startActivity(intent)
        }
    }
}