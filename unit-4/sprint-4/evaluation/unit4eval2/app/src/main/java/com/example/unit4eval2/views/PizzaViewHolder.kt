package com.example.unit4eval2.views

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.unit4eval2.R
import com.example.unit4eval2.views.remote.response.PizzaModel
import com.example.unit4eval2.views.remote.response.Size

class PizzaViewHolder(private val view: View,val clicklistener:onAddclicked):RecyclerView.ViewHolder(view) {

    var tvname:TextView
    var tvdisc:TextView
    var tvprice:TextView
    var mbtnadd:Button

    init {
        tvname=view.findViewById(R.id.tvname)
        tvdisc=view.findViewById(R.id.tvdisc)
        tvprice=view.findViewById(R.id.tvprice)
        mbtnadd=view.findViewById(R.id.btnaddCart)



    }

    fun setdata(pizalist: PizzaModel, pizalist2: Size){
        view.apply {
            tvname.text = pizalist.name
            tvdisc.text = pizalist.description
            tvprice.text = pizalist.crusts[0].sizes[0].price.toString()
            mbtnadd.setOnClickListener {
                clicklistener.onitemClicked(adapterPosition, pizalist)
            }
        }
    }
}