package com.example.pch.background

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.LinearLayout

class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    init {
        inflate(context,R.layout.view_nationality,this)
        setOnClickListener { Log.d("custom","DURLSRK") }
    }
}