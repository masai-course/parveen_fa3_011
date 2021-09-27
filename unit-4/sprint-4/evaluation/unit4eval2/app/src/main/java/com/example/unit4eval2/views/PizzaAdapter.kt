package com.example.unit4eval2.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.unit4eval2.R

class PizzaAdapter(val pizzalist:PizzaModel,val pizzalist2:Size,val clicklistener:onAddclicked):RecyclerView.Adapter<PizzaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
      val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
      return PizzaViewHolder(view,clicklistener)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val pizamodel=pizzalist
        val pizzalist2=pizzalist2
        holder.setdata(pizamodel,pizzalist2)


    }

    override fun getItemCount(): Int {
        return pizzalist.getsize.size
    }
}