package com.example.homease

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class own_signup : AppCompatActivity() {
    private lateinit var result: TextView
    private lateinit var editText: EditText
    private lateinit var button1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_own_signup)

        val tv = findViewById<TextView>(R.id.result)
        val b = findViewById<Button>(R.id.button)
        val an = findViewById<EditText>(R.id.aadhar_edt_text)
        val requestQueue = Volley.newRequestQueue(this)

//        b.setOnClickListener {
//            val aadhaar = an.text.toString()
//            tv.text = ""
//            an.setText("")
//
//            val jb = JSONObject()
//            try {
//                jb.put("aadhaar", aadhaar)
//            } catch (e: JSONException) {
//                throw RuntimeException(e)
//            }
//            var url: String = "https://api.apyhub.com/validate/aadhaar"
//
//            val jsonObjectRequest = JsonObjectRequest(
//                Request.Method.POST, url, jb, { response ->
//                    Log.d()
//                }, {
//
//                }
//            )
//
//
//            val jsonObjectRequest = JsonObjectRequest(
//                Request.Method.POST, url, jb,
//                { response ->
//                    if (response == null) {
//                        Toast.makeText(this, "Error3", Toast.LENGTH_SHORT).show()
//                    }
//                    try {
//                        tv.text = response.getString("data")
//                    } catch (e: JSONException) {
//                        Toast.makeText(this, "" + e.message, Toast.LENGTH_SHORT).show()
//                        e.printStackTrace()
//                    }
//                },
//                { error -> Toast.makeText(this, "Error1 : $error", Toast.LENGTH_SHORT).show() }
//            ) {
//                @Throws(AuthFailureError::class)
//                override fun getHeaders(): Map<String, String> {
//                    val params: MutableMap<String, String> = HashMap()
//                    params["Content-type"] = "application/json"
//                    params["apy-token"] = "APY0iiy7Azfn20hIj1DNKqXH0tfW2wa4OqkLY7oSPuwtzhLfbcoWGKehgKA4AEOhrm0Xiv7FV"
//                    params["aadhaar"] = "461023573455"
//                    return params
//                }
//
//                override fun getBody(): ByteArray {
//                    return super.getBody()
//                }
//            }
//            requestQueue.add(jsonObjectRequest)
//        }
    }
}
