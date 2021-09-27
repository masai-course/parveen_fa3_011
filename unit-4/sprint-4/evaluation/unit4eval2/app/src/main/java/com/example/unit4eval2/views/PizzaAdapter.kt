package com.example.unit4eval2.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.unit4eval2.R
import com.example.unit4eval2.views.remote.response.PizzaModel
import com.example.unit4eval2.views.remote.response.Size

class PizzaAdapter(val pizzalist:List<PizzaModel>, val pizzalist2:List<Size>, val clicklistener:onAddclicked):RecyclerView.Adapter<PizzaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
      val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
      return PizzaViewHolder(view,clicklistener)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val pizamodel=pizzalist[position]
        val pizzalist2=pizzalist2[position]
        holder.setdata(pizamodel,pizzalist2)


    }

    override fun getItemCount(): Int {
        return pizzalist.size
    }
}