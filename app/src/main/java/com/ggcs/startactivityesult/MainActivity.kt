package com.example.startactivityesult

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Explicit Intent - Go to SecondActivity
        findViewById<Button>(R.id.btnExplicitIntent).setOnClickListener {
            val inputText = findViewById<EditText>(R.id.inputText).text.toString()
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("USER_INPUT", inputText)
            }
            startActivity(intent)
        }

        // Implicit Intent - Open Web Page
        findViewById<Button>(R.id.btnImplicitIntentWeb).setOnClickListener {
            val webpage = Uri.parse(getString(R.string.default_web_url))
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            
            // Verify that the intent will resolve to an activity
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        // Implicit Intent - Share Text
        findViewById<Button>(R.id.btnImplicitIntentShare).setOnClickListener {
            val shareText = getString(R.string.default_share_text)
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, shareText)
                type = "text/plain"
            }
            
            // Verify that the intent will resolve to an activity
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(Intent.createChooser(intent, null))
            }
        }
    }
}