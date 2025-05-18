package com.example.startactivityesult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        findViewById<Button>(R.id.btnSubmitResult).setOnClickListener {
            val result = findViewById<EditText>(R.id.etResult).text.toString()
            val resultIntent = Intent().apply {
                putExtra("RESULT", result)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}