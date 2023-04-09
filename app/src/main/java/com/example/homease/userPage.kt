package com.example.homease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.cardview.widget.CardView

class userPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_page)

        val loc = findViewById<EditText>(R.id.editText6)
        val search = findViewById<Button>(R.id.search)
        val muradroom = findViewById<CardView>(R.id.room7)

        search.setOnClickListener {

            if (loc.text.toString().equals("Muradnagar")) {
                muradroom.visibility = View.VISIBLE
            }
        }
        muradroom.setOnClickListener{
            val intent = Intent(this , Muradhome::class.java)
            startActivity(intent)
        }

    }
}