package com.example.pch.customview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.view_switch_item.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("visible", "${View.VISIBLE}")
        Log.d("visible", "${View.GONE}")
        val sview = findViewById<PaySwitchCustomView>(R.id.customSwitch)
        sview.setting_switch.setOnCheckedChangeListener { buttonView, isChecked ->
            when(isChecked){
                true -> Log.d("Switch","true")
                false -> Log.d("Switch","false")
            }
        }
    }
}
