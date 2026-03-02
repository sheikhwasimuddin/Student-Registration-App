package com.example.studentregistration

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvDetails = findViewById<TextView>(R.id.tvDetails)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")
        val roll = intent.getStringExtra("roll")
        val city = intent.getStringExtra("city")
        val gender = intent.getStringExtra("gender")

        tvDetails.text = """
            Name: $name
            Email: $email
            Roll No: $roll
            Phone: $phone
            City: $city
            Gender: $gender
        """.trimIndent()
    }
}