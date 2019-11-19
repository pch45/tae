package com.example.pch.customview

import android.content.Context
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ImageSpan
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.example.pch.customview.databinding.ViewActionMenuBinding

class PayActionMenu @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: ViewActionMenuBinding by lazy {
        DataBindingUtil.inflate<ViewActionMenuBinding>(
            LayoutInflater.from(context),
            R.layout.view_action_menu,
            this,
            true
        )
    }
    private val builder = SpannableStringBuilder()

    /**
     * ActionMenu의 Title
     */
    var title: String
        set(@StringRes value) {
            binding.actionTitle.text = value
        }
        get() {
            return binding.actionTitle.text.toString()
        }

    /**
     * ActionMenu에서 볼 수 있는 사용자의 앱 정보
     * Ex) 앱 버전(2.0.0), 사용 여부(사용 중) 등
     */
    var information: String?
        set(@StringRes value) {
            binding.actionInformation.text = value
            if (value != null) {
                setInformationVisibility(View.VISIBLE)
            } else {
                setInformationVisibility(View.GONE)
            }
        }
        get() {
            return binding.actionInformation.text.toString()
        }

    init {

        context.obtainStyledAttributes(attrs, R.styleable.PayActionMenu).run {
            title = getText(R.styleable.PayActionMenu_action_title).toString()
            information = getText(R.styleable.PayActionMenu_action_information)?.toString()

            setTitleColor(
                getColor(
                    R.styleable.PayActionMenu_action_title_color,
                    Color.BLACK
                )
            )
            setInformationColor(
                getColor(
                    R.styleable.PayActionMenu_action_information_color,
                    Color.BLUE
                )
            )
//            setWarningImage(
//                getResourceId(
//                    R.styleable.PayActionMenu_action_warning_image,
//                    R.drawable.ic_badge_large_warning_36_dp
//                )
//            )
            setWarningImageVisibility(
                getInt(
                    R.styleable.PayActionMenu_action_warning_image_visibility,
                    View.GONE
                ), R.drawable.ic_badge_large_warning_36_dp
            )
            recycle()
        }
        isClickable = true
        isFocusable = true
        background = ContextCompat.getDrawable(context,R.drawable.ripple)
    }


    /**
     * Title의 Color를 Int로 받는 함수
     */
    fun setTitleColor(@ColorInt color: Int) {
        binding.actionTitle.setTextColor(color)
    }

    /**
     * Information의 Color를 Int로 받는 함수
     */
    fun setInformationColor(@ColorInt color: Int) {
        binding.actionInformation.setTextColor(color)
    }

    /**
     * Information의 Visibility를 지정하는 함수
     */
    fun setInformationVisibility(visibility: Int) {
        if (visibility == View.GONE || visibility == View.VISIBLE || visibility == View.INVISIBLE) {
            binding.actionInformation.visibility = visibility
        } else {
            throw IllegalArgumentException("올바른 Visibility 값을 입력해주세요")
        }
    }

    /**
     * WarningImage를 지정하는 함수
     */
    fun setWarningImage(@DrawableRes imageId: Int) {
        setWarningImageVisibility(View.VISIBLE,imageId)
    }

    /**
     * Content의 Visibility를 지정하는 함수
     */
    fun setWarningImageVisibility(visibility: Int, @DrawableRes imageId: Int) {
        if (visibility == View.GONE || visibility == View.VISIBLE || visibility == View.INVISIBLE) {
//            binding.actionWarningImage.visibility = visibility
            when(visibility) {
                View.GONE -> {
//                    builder.append("$title")
//                    binding.actionTitle.text = builder
                }
                else -> {
                    builder.append("$title ")
                    builder.append(" ",ImageSpan(context,imageId),0)
                    binding.actionTitle.text = builder
                }
            }
            builder.clear()
        } else {
            throw IllegalArgumentException("올바른 Visibility 값을 입력해주세요")
        }
    }
}