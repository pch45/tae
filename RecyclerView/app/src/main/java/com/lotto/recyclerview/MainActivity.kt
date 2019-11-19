package com.lotto.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import android.view.ViewTreeObserver



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        first.visibility = View.GONE
        Handler().postDelayed({
            rv.adapter = RvAdapter()
            rv.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        //At this point the layout is complete and the
                        //dimensions of recyclerView and any child views are known.
                        //Remove listener after changed RecyclerView's height to prevent infinite loop
                        first.visibility = View.VISIBLE
                        rv.viewTreeObserver.removeOnGlobalLayoutListener(this)
                    }
                })
        }, 2000)
    }

    class RvAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return if (viewType == 1) {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_second, parent, false)
                RvViewHolder(view)
            } else {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_first, parent, false)
                RvViewHolder(view)
            }
        }

        override fun getItemCount(): Int {
            return 120
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        }

        override fun getItemViewType(position: Int): Int {
            return if (position == 0) 0 else 1
        }
    }

    class RvViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}
