package com.example.unit5eval1.views

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.unit5eval1.R
import com.example.unit5eval1.data.ResponseModelItem
import com.squareup.picasso.Picasso

class getviewhlder(private val view: View):RecyclerView.ViewHolder(view) {

    private var ivimg:ImageView
    private var tvcountry:TextView
    private var tvdead:TextView
    private var tvbirth:TextView

    init {
        ivimg=view.findViewById(R.id.ivimage)
        tvcountry=view.findViewById(R.id.tvcountry)
        tvdead=view.findViewById(R.id.tvdeath)
        tvbirth=view.findViewById(R.id.tvbirth)


    }

    fun setdata(resp:ResponseModelItem){
        view.apply {
        tvcountry.text=resp.country.name
            tvdead.text=resp.deathday
            tvbirth.text=resp.birthday
            Picasso.get().load(resp.image.medium).into(ivimg)

        }
    }
}