package com.example.u5eval2

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.u5eval2.data.Article
import com.squareup.picasso.Picasso

class newsViewHOlder(private val view: View): RecyclerView.ViewHolder(view){

    var img: ImageView
    var tvtitle: TextView
    var tvdate: TextView
    var tvdesc: TextView
    var btn1: Button

    init {
        img=view.findViewById(R.id.ivimage)
        tvtitle=view.findViewById(R.id.title)
        tvdate=view.findViewById(R.id.tvdate)
        tvdesc=view.findViewById(R.id.tvdisc)
        btn1=view.findViewById(R.id.btn1)


    }
    fun setdata(res: Article){
        view.apply {
            tvtitle.text=res.title
            tvdate.text=res.publishedAt
            tvdesc.text=res.description
            Picasso.get().load(res.url).into(img)

        }
    }
}