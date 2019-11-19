package com.lotto.app

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                textMessage.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                textMessage.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                textMessage.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        search.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                edit.text.toString().let {
                    if(it.isNullOrEmpty()) return@launch
                    else {
                        APIClient.getRetrofitService().getLotto("getLottoNumber", it.toInt()).run {
                            if(returnValue != "success") return@launch
                            textMessage.text = "회차 : ${it.toInt()}\n" +
                                    "1등 전체 당첨 금액 : $firstAccumamnt\n" +
                                    "1등 당첨 금액 : $firstWinamnt\n" +
                                    "1등 당첨 인원 : $firstPrzwnerCo\n\n" +
                                    "당첨 번호\n" +
                                    "$drwtNo1 $drwtNo2 $drwtNo3 $drwtNo4 $drwtNo5 $drwtNo6\n\n" +
                                    "보너스 번호 : $bnusNo"
                            Log.d("hans",toString())
                        }
                    }

                }
            }
        }
    }
}