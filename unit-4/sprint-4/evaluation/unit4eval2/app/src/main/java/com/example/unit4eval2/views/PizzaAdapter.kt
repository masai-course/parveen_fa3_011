package com.example.unit4eval2.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.unit4eval2.R

class PizzaAdapter(val pizzalist:PizzaModel):RecyclerView.Adapter<PizzaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
      val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
      return PizzaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val pizamodel=pizzalist[position]


    }

    override fun getItemCount(): Int {
        return pizzalist.crusts.size
    }
}