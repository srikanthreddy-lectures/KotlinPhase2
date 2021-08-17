package com.example.kotlindemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlindemoapp.databinding.ActivityFragmantBinding

class FragmantActivity : AppCompatActivity() {

    lateinit var binding:ActivityFragmantBinding

    lateinit var myModel: MyVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.activity_fragmant)

       // val f1 = findViewById<Button>(R.id.demo_fragment_btn1)
       // val f2 = findViewById<Button>(R.id.demo_fragment_btn2)

        binding.demoFragmentBtn1.setOnClickListener(View.OnClickListener {
            replaceFragments(FirstFragment())
        })

        binding.demoFragmentBtn2.setOnClickListener(View.OnClickListener {
            replaceFragments(SecondFragment())
        })

        myModel = ViewModelProvider(this).get(MyVM::class.java)
        myModel.getData().observe(this, Observer {
            binding.vmName.text = it.toString()
        })
    }

    private fun replaceFragments(a: Fragment){
        var fm = supportFragmentManager
        var ft = fm.beginTransaction()
        ft.replace(R.id.demo_fragment_container, a)
        ft.commit()
    }
}