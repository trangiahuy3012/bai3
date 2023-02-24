package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R

class ProfileActivity : AppCompatActivity() {
    lateinit var stringname: String
    lateinit var stringemail: String
    lateinit var stringphone: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val fullNameTextView = findViewById<TextView>(R.id.Fullname)
        val emailTextView = findViewById<TextView>(R.id.Email)
        val phoneTextView = findViewById<TextView>(R.id.Phonenumber)
        data class User(
            val fullName: String,
            val email: String,
            val phoneNumber: String
        )
        val user = User("Huy Tran", "huy.tran@example.com", "0123456789")
        fullNameTextView.text = user.fullName
        emailTextView.text = user.email
        phoneTextView.text = user.phoneNumber
        val sharedPreferences = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("fullName", fullNameTextView.text.toString())
        editor.putString("email", emailTextView.text.toString())
        editor.putString("phoneNumber", phoneTextView.text.toString())

        editor.apply()

    }

}