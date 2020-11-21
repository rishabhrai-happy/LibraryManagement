package com.example.librarymanagement

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NodeAdapter1(val arraylist : ArrayList<Data>):RecyclerView.Adapter<NodeAdapter1.viewHolder1>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder1 {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_cardview, parent, false)
        return NodeAdapter1.viewHolder1(v)
    }

    override fun onBindViewHolder(holder: viewHolder1, position: Int) {
        val user: Data = arraylist[position]
        holder.textViewName.text = user.getName()
    }

    override fun getItemCount(): Int {
        return arraylist.size
    }

    class viewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName = itemView.findViewById(R.id.text_View) as TextView
    }

}
