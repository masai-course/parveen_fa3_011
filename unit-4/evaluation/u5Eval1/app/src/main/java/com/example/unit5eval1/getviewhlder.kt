package com.example.unit5eval1

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.unit5eval1.data.ResponseModel
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

    fun setdata(resp:ResponseModel){
        view.apply {
        tvcountry.text=resp[position].country.name
            tvdead.text=resp[position].deathday
            tvbirth.text=resp[position].birthday
            Picasso.get().load(resp[position].image.medium).into(ivimg)

        }
    }
}