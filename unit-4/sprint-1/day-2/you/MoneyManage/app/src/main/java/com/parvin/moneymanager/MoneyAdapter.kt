package com.parvin.moneymanager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MoneyAdapter(val context: Context, val modelList: MutableList<Model>,val listener:onItemClicked) : RecyclerView.Adapter<MoneyAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(context)
        val view1: View = inflater.inflate(R.layout.item_layout, parent, false)
        return TaskViewHolder(view1)

    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val data = modelList.get(position)
        holder.title.text = data.title
        holder.date.text = data.date
        holder.amount.text=data.Amount

        holder.edittv.setOnClickListener {
            listener.onEditClicked(data)
        }

        holder.deletetv.setOnClickListener {
            listener.onDeleteClicked(data)
        }

    }

    override fun getItemCount(): Int {
        return modelList.size
    }


    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var date: TextView
        var amount:TextView

        var edittv: TextView
        var deletetv: TextView

        init {
            title = itemView.findViewById(R.id.tvTaskTitle)
            date = itemView.findViewById(R.id.tvDate)
            amount=itemView.findViewById(R.id.tvAmount)
            edittv=itemView.findViewById(R.id.editTv)
            deletetv=itemView.findViewById(R.id.deleteTv)
        }
    }
}