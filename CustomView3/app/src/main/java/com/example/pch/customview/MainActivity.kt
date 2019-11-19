package com.example.pch.customview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Log.d("visible", "${View.VISIBLE}")
//        Log.d("visible", "${View.GONE}")
//        val sview = findViewById<PaySwitchMenu>(R.id.customSwitch)
//
//        val handler = Handler()
//        handler.postDelayed( { sview.toggle() },1000)
//
        val nview = findViewById<PaySwitchMenu>(R.id.customSwitch2)
    }
}
