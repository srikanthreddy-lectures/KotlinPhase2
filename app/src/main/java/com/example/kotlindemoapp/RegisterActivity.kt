package com.example.kotlindemoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val firstname = findViewById<EditText>(R.id.et_firstname)
        val lastname = findViewById<EditText>(R.id.et_lastname)
        val phone =findViewById<EditText>(R.id.et_phone)
        val register = findViewById<Button>(R.id.add_btn)

        val result =findViewById<TextView>(R.id.result)

        val name = Intent().getStringExtra("name")
        result.text = name.toString()

        val config = Room.databaseBuilder(this,UserDatabase::class.java,"sonet.db")
        val db = config.build()

        register.setOnClickListener(View.OnClickListener {
            lifecycleScope.launch {
                var dao = db.userDao()
                var user = User(0,firstname.text.toString(),lastname.text.toString(),phone.text.toString())
                dao.addUser(user)
                var data = dao.readAllUser()

                result.text = "${data.get(data.size-1).firstName.toString()}  ${data.get(data.size-1).lastName.toString()}"
            }
        })

    }
}