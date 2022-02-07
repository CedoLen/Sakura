package com.example.sakura.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sakura.Network.quotes
import com.example.sakura.R

class stateAdapter(val context: Context, val list:quotes): RecyclerView.Adapter<stateAdapter.MyVM>() {
    class MyVM(itemView:View):RecyclerView.ViewHolder(itemView) {
        val image:ImageView = itemView.findViewById(R.id.state_image)
        val title: TextView = itemView.findViewById(R.id.state_title)
        val description:TextView = itemView.findViewById(R.id.state_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVM {
        val root =LayoutInflater.from(context).inflate(R.layout.state_adapter,parent,false)
        return MyVM(root)
    }

    override fun onBindViewHolder(holder: MyVM, position: Int) {
        Glide.with(context).load(list.data[position].image).into(holder.image)
        holder.title.text=list.data[position].title
        holder.description.text=list.data[position].description
    }

    override fun getItemCount(): Int {
        return  list.data.size
    }
}