package com.example.multiplelayout.views

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.multiplelayout.models.chatModel
import kotlinx.android.synthetic.main.bot_layout.view.*

class botViewHolder(val view:View, val clicklistener: clicklistener):RecyclerView.ViewHolder(view) {


    fun setdata(text1:chatModel){

        view.apply {
            tvtext1.text=text1.msg1
            tvtext2.text=text1.msg2
            tvtext3.text=text1.msg3
            btncancel.setOnClickListener {
                clicklistener.onCancelClick(adapterPosition)
            }

            btnstatus.setOnClickListener {
                clicklistener.onCancelClick(adapterPosition)
            }

        }

    }
}