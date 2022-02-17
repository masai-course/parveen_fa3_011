package com.example.multiplelayout.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multiplelayout.R

class mainAdapter(val context: Context):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view:View
        return if(viewType==0) {

                val view = LayoutInflater.from(context)
                    .inflate(R.layout.bot_layout, parent, false)
                return botViewHolder(view)
            }else
            {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.user_layout, parent, false)
                return userviewHolder(view)
            }
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewtype: Int = basemodellist.get(position).getviewtype()
        when (viewtype) {
            0 -> if (holder is botViewHolder) {
                val senderModel: senderModel = basemodellist.get(position) as senderModel
                (holder as botViewHolder).setdata(senderModel)
            }
            1 -> if (holder is userviewHolder) {
                val receiverModel: ReceiverModel = basemodellist.get(position) as ReceiverModel
                (holder as userviewHolder).setdata(receiverModel)
            }
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }




}