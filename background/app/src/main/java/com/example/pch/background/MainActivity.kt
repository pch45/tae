package com.example.pch.background

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_nationality.view.*

class MainActivity : AppCompatActivity() {

    private val list: MutableList<CustomView> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = CustomAdapter(list)
            setOnClickListener {
                Toast.makeText(context,"DKSSUD",Toast.LENGTH_LONG).show()
            }
        }
        for(i in 0..5) {
            list.add(CustomView(this))
        }
        list.sortBy { it.nationality_korean.text.toString() }
        //rv.adapter?.notifyDataSetChanged()
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("kakaopay://payment/autopay")))
    }

    fun onClick() {
        Toast.makeText(this,"DKSSUD",Toast.LENGTH_LONG).show()
    }
}
