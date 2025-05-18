package com.example.helloworldapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val actionButton = findViewById<Button>(R.id.actionButton)
        actionButton.setOnClickListener {
            Toast.makeText(this, "Button in Activity 2 clicked!", Toast.LENGTH_LONG).show()
        }
    }
}