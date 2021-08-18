package com.example.myapplication

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class postviewHolder(private val view:View):RecyclerView.ViewHolder(view) {

    fun setdata(responseModelitem:ResponseModelItem){
        view.apply {
            tvName.text=responseModelitem.name
            tvBody.text=responseModelitem.body
            tvEmail.text=responseModelitem.email

        }
    }
}