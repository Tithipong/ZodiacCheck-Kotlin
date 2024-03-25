package com.example.zodiachoroscope

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val startAppButton: Button = findViewById(R.id.btn_start_app)
        startAppButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val exitAppButton: Button = findViewById(R.id.btn_exit)
        exitAppButton.setOnClickListener {
            finishAffinity()
        }
    }
}