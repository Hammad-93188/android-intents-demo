package com.example.startactivityesult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Display received data
        val receivedData = intent.getStringExtra("USER_INPUT") ?: ""
        findViewById<TextView>(R.id.tvReceivedData).text = 
            getString(R.string.received_data, receivedData)

        // Button to start ResultActivity for result
        findViewById<Button>(R.id.btnSendResult).setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_RESULT)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        
        if (requestCode == REQUEST_CODE_RESULT && resultCode == Activity.RESULT_OK) {
            val result = data?.getStringExtra("RESULT") ?: ""
            findViewById<TextView>(R.id.tvResult).text = 
                getString(R.string.result_received, result)
        }
    }

    companion object {
        const val REQUEST_CODE_RESULT = 1
    }
}