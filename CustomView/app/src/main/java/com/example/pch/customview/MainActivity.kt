package com.example.pch.customview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.FragmentManager
import android.support.v4.content.ContextCompat
import android.support.v4.widget.NestedScrollView
import android.text.Spannable
import android.text.Spanned
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toolbar
import kotlinx.android.synthetic.main.toolbar_navigation_title.view.*

class MainActivity : AppCompatActivity() {
    private val fragmentManager : FragmentManager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.toolbar_title.text = "설정"
        toolbar.setNavigationOnClickListener {
            finish()
        }
        val appBar = findViewById<AppBarLayout>(R.id.app_bar)

        val scroll = findViewById<NestedScrollView>(R.id.setting_scroll)



        scroll.viewTreeObserver.addOnScrollChangedListener {
            appBar.isSelected = scroll.canScrollVertically(-1)
        }

        val myInfo = findViewById<PayActionMenu>(R.id.setting_app_version)
        myInfo.setOnClickListener {
            fragmentManager.beginTransaction().replace(R.id.setting_linear,PayMyInformationFragment()).commit()
        }

        findViewById<PayActionMenu>(R.id.setting_app_version).setWarningImage(R.drawable.ic_arrow_back_grey_01_24_dp)

    }
}
