package com.example.librarymanagement

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(val arraylist : ArrayList<Data>) : RecyclerView.Adapter<NoteAdapter.viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_cardview,parent,false)
        return viewHolder(v)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val user : Data = arraylist[position]
        holder.textViewName.text = user.getName()
    }

    override fun getItemCount(): Int {
        return arraylist.size
    }


    class viewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val textViewName = itemView.findViewById(R.id.text_View)as TextView
    }


}