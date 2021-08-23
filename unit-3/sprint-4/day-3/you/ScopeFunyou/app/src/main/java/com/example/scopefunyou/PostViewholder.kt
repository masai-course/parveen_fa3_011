package com.example.scopefunyou

import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*

class PostViewholder(private val view:View,val itemclicklistener: itemclickListener):RecyclerView.ViewHolder(view) {

    fun setdata(datalist:Data){
        view.apply {
            Picasso.get().load(datalist.avatar).into(ivimage)
            tvname.text=datalist.first_name
            tvemail.text=datalist.email
            caed.setOnClickListener {
                itemclickListener.onitemClicked(adapterPosition,datalist)
            }
        }
    }
}