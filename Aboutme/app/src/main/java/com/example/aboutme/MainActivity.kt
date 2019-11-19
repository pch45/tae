package com.example.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
//        val doneButton : Button = findViewById(R.id.done_button)
//        val hiddenText : TextView = findViewById(R.id.hidden)
//        val editText : EditText = findViewById(R.id.edit)
        binding.doneButton.setOnClickListener { addNick(it) }

    }

    private fun addNick(view: View) {
        binding.apply {
            doneButton.setOnClickListener {
                edit.visibility = View.GONE
                doneButton.visibility = View.GONE
                hidden.visibility = View.VISIBLE
                hidden.text = edit.text
            }
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
