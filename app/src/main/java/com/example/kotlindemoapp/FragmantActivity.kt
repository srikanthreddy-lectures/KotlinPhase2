package com.example.kotlindemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmantActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmant)

        val f1 = findViewById<Button>(R.id.demo_fragment_btn1)
        val f2 = findViewById<Button>(R.id.demo_fragment_btn2)

        f1.setOnClickListener(View.OnClickListener {
            replaceFragments(FirstFragment())
        })

        f2.setOnClickListener(View.OnClickListener {
            replaceFragments(SecondFragment())
        })
    }

    private fun replaceFragments(a: Fragment){
        var fm = supportFragmentManager
        var ft = fm.beginTransaction()
        ft.replace(R.id.demo_fragment_container, a)
        ft.commit()
    }
}