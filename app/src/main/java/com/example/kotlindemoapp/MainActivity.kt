package com.example.kotlindemoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val act_online_class = findViewById<TextView>(R.id.act_online_class)

        act_online_class.setOnClickListener(View.OnClickListener {
            //Toast.makeText(this,"Hello World",Toast.LENGTH_LONG).show()
            val intent = Intent(this,BranchActivity::class.java)
            startActivity(intent)
            //finish()
        })
    }
}