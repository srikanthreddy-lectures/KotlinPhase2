package com.example.kotlindemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlindemoapp.databinding.ActivityFirebaseDemoBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class FirebaseDemoActivity : AppCompatActivity() {

    lateinit var binding:ActivityFirebaseDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirebaseDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = Firebase.database
        val myRef = database.getReference("name")

        myRef.setValue("Ram")

        // Read from the database
        myRef.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = snapshot.getValue<String>()
                binding.readData.text = value
                //Log.d(TAG, "Value is: " + value)
            }

            override fun onCancelled(error: DatabaseError) {
                //Log.w(TAG, "Failed to read value.", error.toException())
            }

        })

    }
}