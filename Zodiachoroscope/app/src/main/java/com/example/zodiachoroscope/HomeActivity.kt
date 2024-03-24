package com.example.zodiachoroscope

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val start_app: Button = findViewById(R.id.btn_start_app)
        start_app.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val exit_app: Button = findViewById(R.id.btn_exit)
        exit_app.setOnClickListener {
            finishAffinity()
        }
    }
}