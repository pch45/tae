package com.example.pch.background

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_nationality.view.*

class CustomAdapter(private val nationalityList: MutableList<CustomView>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class CustomViewHolder(itemView: CustomView) : RecyclerView.ViewHolder(itemView) {
        fun onClick() {
            customView.nationality_korean.text ="${customView.nationality_korean.text}1"
            Log.d("custom","abc?")
        }

        val customView = itemView
        init {
            customView.setOnClickListener {
                onClick()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.view_nationality,parent,false)
        return CustomViewHolder(CustomView(parent.context).apply{
            layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        })
    }

    override fun getItemCount(): Int {
        return nationalityList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is CustomViewHolder) {
            holder.customView.run{
                nationality_korean.text = nationalityList[position].nationality_korean.text
                nationality_english.text = nationalityList[position].nationality_english.text
            }
        }
    }

}

interface ItemClickListener