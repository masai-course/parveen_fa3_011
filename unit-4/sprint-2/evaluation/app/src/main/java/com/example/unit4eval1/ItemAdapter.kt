package com.example.unit4eval1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(val context: Context,val itemlist:MutableList<Model>):RecyclerView.Adapter<ItemAdapter.itemViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val layoutInflater=LayoutInflater.from(context)
        val view=layoutInflater.inflate(R.layout.item_layout,parent,false)
        return itemViewHolder(view)
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
          val item=itemlist.get(position)
        holder.title.text=item.title
        holder.disc.text=item.desc
        holder.amount.text=item.amount
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

    class itemViewHolder(view: View):RecyclerView.ViewHolder(view){

        var title:TextView
        var disc:TextView
        var amount:TextView

        init{
            title=view.findViewById(R.id.tv1)
            disc=view.findViewById(R.id.tv2)
            amount=view.findViewById(R.id.tv3)
        }


    }
}