package com.example.kotlindemoapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.TextView

class BranchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_branch)

        val act_open_app = findViewById<Button>(R.id.act_open_app)

        act_open_app.setOnClickListener(View.OnClickListener {
            //var uri = Uri.parse("tel:12122321")
            var uri = Uri.parse("https://www.google.com")
            val intent = Intent(Intent.ACTION_VIEW,uri)

            //val intent = Intent("android.media.action.IMAGE_CAPTURE")
            startActivity(intent)
        })
    }
}