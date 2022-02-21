package com.example.multiplelayout.views

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.multiplelayout.models.chatModel
import kotlinx.android.synthetic.main.user_layout.view.*

class userviewHolder(val view: View):RecyclerView.ViewHolder(view) {


    fun setdata(chatModel: chatModel){

        view.apply {
         tvuser.text= chatModel.msg1
        }
    }
}