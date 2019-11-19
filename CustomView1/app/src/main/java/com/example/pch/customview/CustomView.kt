package com.example.pch.customview

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.custom_view.view.*

class CustomView @JvmOverloads constructor(context: Context, attrs : AttributeSet? = null, defStyleAttr : Int = 0)
    : ConstraintLayout(context,attrs,defStyleAttr){
    init{
        LayoutInflater.from(context).inflate(R.layout.custom_view,this,true)
        val typedArray = getContext().obtainStyledAttributes(attrs,R.styleable.CustomView)
        val menuName = typedArray.getText(R.styleable.CustomView_menu_name)
        setting_menu_name.text = menuName
    }
}