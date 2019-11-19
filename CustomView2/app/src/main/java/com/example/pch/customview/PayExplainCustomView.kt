package com.example.pch.customview

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.view_explain_item.view.*

class PayExplainCustomView @JvmOverloads constructor(context: Context, attrs : AttributeSet? = null, defStyleAttr : Int = 0)
    : ConstraintLayout(context,attrs,defStyleAttr){
    init{
        LayoutInflater.from(context).inflate(R.layout.view_explain_item,this,true)
        val typedArray = getContext().obtainStyledAttributes(attrs,R.styleable.PayExplainCustomView)
        val textExplain = typedArray.getText(R.styleable.PayExplainCustomView_setting_explain)

        val upLineVisibility = typedArray.getInt(R.styleable.PayExplainCustomView_explain_up_line_visibility, View.GONE)
        val downLineVisibility = typedArray.getInt(R.styleable.PayExplainCustomView_explain_down_line_visibility, View.GONE)

        setting_menu_name_explain.text = textExplain

        up_line.visibility = upLineVisibility
        down_line.visibility = downLineVisibility

        typedArray.recycle()
    }
}