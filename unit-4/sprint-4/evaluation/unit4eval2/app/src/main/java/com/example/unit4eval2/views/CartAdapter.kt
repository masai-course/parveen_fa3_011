package com.example.unit4eval2.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.unit4eval2.R
import com.example.unit4eval2.views.model.Model

class CartAdapter(val context: Context,val modellist:MutableList<Model>):RecyclerView.Adapter<CartAdapter.CartviewHolder>() {






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartviewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.itemlayout2,parent,false)
        return CartviewHolder(view)
    }

    override fun onBindViewHolder(holder: CartviewHolder, position: Int) {
        val data=modellist.get(position)
        holder.text1.text=data.name
        holder.text2.text= data.price.toString()
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class CartviewHolder(view: View):RecyclerView.ViewHolder(view){

        var text1:TextView
        var text2:TextView
        var mbtnremove:Button

        init {
            text1=view.findViewById(R.id.textvv1)
            text2=view.findViewById(R.id.pricetvv)
            mbtnremove=view.findViewById(R.id.btnremove)
        }


    }
}