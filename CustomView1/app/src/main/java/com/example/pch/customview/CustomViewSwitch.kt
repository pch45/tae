package com.example.pch.customview

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.custom_view_switch.view.*

class CustomViewSwitch @JvmOverloads constructor(context: Context, attrs : AttributeSet? = null, defStyleAttr : Int = 0)
    : ConstraintLayout(context,attrs,defStyleAttr){
    init{
        LayoutInflater.from(context).inflate(R.layout.custom_view_switch,this,true)
        val typedArray = getContext().obtainStyledAttributes(attrs,R.styleable.CustomViewSwitch)
        val menuName = typedArray.getText(R.styleable.CustomViewSwitch_menu_name)
        setting_menu_name.text = menuName
    }
}