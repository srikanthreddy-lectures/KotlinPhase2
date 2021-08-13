package com.example.kotlindemoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAvtivity : AppCompatActivity(), MyAdapter.OnItemClickListener {
    val list = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_avtivity)

        val recycler_view = findViewById<RecyclerView>(R.id.rcv)


        var user=User(0,"Scott","Reddy","123456")
        list.add(user)

        recycler_view.adapter = MyAdapter(list,this)
        recycler_view.layoutManager = LinearLayoutManager(this)

    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, RegisterActivity::class.java)
        val itemUser =  list[position]
        intent.putExtra("name",itemUser.firstName)
        startActivity(intent)
    }
}