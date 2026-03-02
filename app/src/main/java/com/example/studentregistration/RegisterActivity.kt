package com.example.studentregistration

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etRoll = findViewById<EditText>(R.id.etRoll)
        val etCity = findViewById<EditText>(R.id.etCity)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {

            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val roll = etRoll.text.toString().trim()
            val city = etCity.text.toString().trim()

            val selectedGenderId = radioGroup.checkedRadioButtonId

            if (name.isEmpty()) {
                etName.error = "Name required"
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Valid email required"
                return@setOnClickListener
            }

            if (password.length < 6) {
                etPassword.error = "Password must be at least 6 characters"
                return@setOnClickListener
            }

            if (phone.length != 10) {
                etPhone.error = "Enter 10 digit number"
                return@setOnClickListener
            }

            if (roll.isEmpty()) {
                etRoll.error = "Roll number required"
                return@setOnClickListener
            }

            if (city.isEmpty()) {
                etCity.error = "City required"
                return@setOnClickListener
            }

            if (selectedGenderId == -1) {
                Toast.makeText(this, "Select Gender", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val gender = findViewById<RadioButton>(selectedGenderId).text.toString()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("email", email)
            intent.putExtra("phone", phone)
            intent.putExtra("roll", roll)
            intent.putExtra("city", city)
            intent.putExtra("gender", gender)

            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }
    }
}