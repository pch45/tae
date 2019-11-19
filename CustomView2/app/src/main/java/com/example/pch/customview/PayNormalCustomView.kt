package com.example.pch.customview

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.view_normal_item.view.*

class PayNormalCustomView  @JvmOverloads constructor(
    context: Context,
    attrs : AttributeSet? = null,
    defStyleAttr : Int = 0
    ) : ConstraintLayout(context,attrs,defStyleAttr) {
    private val typedArray : TypedArray by lazy {
        getContext().obtainStyledAttributes(attrs, R.styleable.PayNormalCustomView)
    }
    init {
        LayoutInflater.from(context).inflate(R.layout.view_normal_item, this, true)
        typedArray.apply{
            setting_menu_name.apply{
                text = getText(R.styleable.PayNormalCustomView_normal_menu_name)
                setTextColor(getColor(R.styleable.PayNormalCustomView_normal_text_color,Color.BLACK))
            }
            setting_sub_text.text = getText(R.styleable.PayNormalCustomView_sub_text)
            setting_alarm_warning.apply {
                visibility = getInt(R.styleable.PayNormalCustomView_alarm_visibility,View.GONE)
                setImageResource(getResourceId(R.styleable.PayNormalCustomView_warning_image, R.drawable.ic_badge_large_warning_36_dp))
            }
            up_line.visibility = getInt(R.styleable.PayNormalCustomView_normal_up_line_visibility, View.GONE)
            down_line.visibility = getInt(R.styleable.PayNormalCustomView_normal_down_line_visibility, View.GONE)
        }
        typedArray.recycle()
    }
}