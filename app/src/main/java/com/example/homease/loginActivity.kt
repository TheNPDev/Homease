package com.example.homease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class loginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val signup = findViewById<TextView>(R.id.sign_up_btn)
        signup.setOnClickListener {
            val intent = Intent(this, signupActivity::class.java)
            startActivity(intent)
        }

        val login = findViewById<Button>(R.id.login_btn)
        login.setOnClickListener {
            val intent = Intent(this, userPage::class.java)
            startActivity(intent)
        }


    }
}