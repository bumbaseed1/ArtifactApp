package com.example.artifactapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val artifactInfoTextView = findViewById<TextView>(R.id.artifactInfoTextView)
        // Set the artifact information dynamically if needed
        artifactInfoTextView.text = "This is an example artifact. It dates back to..."
    }
}

