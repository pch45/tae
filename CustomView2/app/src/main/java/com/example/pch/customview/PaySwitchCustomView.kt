package com.example.pch.customview

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.view_switch_item.view.*

class PaySwitchCustomView @JvmOverloads constructor(context: Context, attrs : AttributeSet? = null, defStyleAttr : Int = 0)
    : ConstraintLayout(context,attrs,defStyleAttr){
    init{
        LayoutInflater.from(context).inflate(R.layout.view_switch_item,this,true)
        val typedArray = getContext().obtainStyledAttributes(attrs,R.styleable.PaySwitchCustomView)
        val menuName = typedArray.getText(R.styleable.PaySwitchCustomView_switch_menu_name)
        val upLineVisibility = typedArray.getInt(R.styleable.PaySwitchCustomView_switch_up_line_visibility, View.GONE)
        val downLineVisibility = typedArray.getInt(R.styleable.PaySwitchCustomView_switch_down_line_visibility, View.GONE)

        setting_menu_name_switch.text = menuName
        up_line.visibility = upLineVisibility
        down_line.visibility = downLineVisibility
        typedArray.recycle()
    }
}