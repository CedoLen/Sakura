package com.example.sakura.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sakura.Network.feelings
import com.example.sakura.R
import com.example.sakura.feel

class FirstAdapter(val context: Context, val list:feelings):
    RecyclerView.Adapter<FirstAdapter.MyVH>()
{
    class MyVH(itemView:View):RecyclerView.ViewHolder(itemView) {
        val imageView:ImageView = itemView.findViewById(R.id.image_feel)
        val textView:TextView=itemView.findViewById(R.id.text_feel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.first_adapter,parent,false)
        return MyVH(root)
    }

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        Glide.with(context).load(list.data[position].image).into(holder.imageView)
        holder.textView.text=list.data[position].title
    }
    override fun getItemCount(): Int {
        return list.data.size
    }
}