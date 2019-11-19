package com.example.pch.customview

import android.content.Context
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.support.annotation.BoolRes
import android.support.annotation.ColorInt
import android.support.annotation.StringRes
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.example.pch.customview.databinding.ViewSwitchMenuBinding

class PaySwitchMenu @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: ViewSwitchMenuBinding by lazy {
        DataBindingUtil.inflate<ViewSwitchMenuBinding>(
            LayoutInflater.from(context),
            R.layout.view_switch_menu,
            this,
            true
        )
    }

    /**
     * SwitchMenu의 Title
     */
    var title: String
        set(@StringRes value) {
            binding.switchTitle.text = value
        }
        get() {
            return binding.switchTitle.text.toString()
        }

    /**
     * Switch의 on/off 상태
     */
    var isChecked: Boolean
        set(@BoolRes value) {
            binding.switchCompat.isChecked = value
        }
        get() {
            return binding.switchCompat.isChecked
        }

    init {
        context.obtainStyledAttributes(attrs, R.styleable.PaySwitchMenu).run {
            title = getText(R.styleable.PaySwitchMenu_switch_title).toString()
            isChecked = getBoolean(R.styleable.PaySwitchMenu_switch_state,false)

            setTitleColor(
                getColor(
                    R.styleable.PaySwitchMenu_switch_title_color,
                    Color.BLACK
                )
            )
            recycle()
        }
    }

    /**
     * Title의 Color를 Int로 받는 함수
     */
    fun setTitleColor(@ColorInt color: Int) {
        binding.switchTitle.setTextColor(color)
    }

    /**
     * Switch를 Toggle하는 함수
     */
    fun toggle() {
        binding.switchCompat.toggle()
    }
}