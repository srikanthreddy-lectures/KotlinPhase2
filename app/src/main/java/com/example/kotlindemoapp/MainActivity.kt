package com.example.kotlindemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn1)

        btn.setOnClickListener(View.OnClickListener {
            Toast.makeText(this,"Hello World",Toast.LENGTH_LONG).show()
        })
    }
}