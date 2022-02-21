package com.example.multiplelayout.views

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multiplelayout.R
import com.example.multiplelayout.models.chatModel

class mainAdapter(val context: Context, var list: List<chatModel>, val clicklistener: clicklistener):RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    var typeview:Int= 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view:View
        return if(viewType==0) {

                val view = LayoutInflater.from(context)
                    .inflate(R.layout.bot_layout, parent, false)
                return botViewHolder(view, clicklistener)
            }else
            {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.user_layout, parent, false)
                return userviewHolder(view)
            }


        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        val viewtype: Int = typeview
        if (viewtype==0) {

                val senderText: chatModel = list.get(position)
            (holder as botViewHolder).setdata(senderText)
            }else
             {
                val receiverModel: chatModel = list.get(position)
                (holder as userviewHolder).setdata(receiverModel)
            }

        if (typeview==0){
            typeview=1
        }else{
            typeview=0
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun getItemViewType(position: Int): Int {
        return typeview
    }


}