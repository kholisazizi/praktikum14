package com.kholison_19102147.praktikum6.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kholison_19102147.praktikum6.MyData
import com.kholison_19102147.praktikum6.R
import de.hdodenhof.circleimageview.CircleImageView

class ListMyDataAdapter(private val listMyData: ArrayList<MyData>) :
    RecyclerView.Adapter<ListMyDataAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ListViewHolder(view)
    }
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMyData[position])
    }
    override fun getItemCount(): Int = listMyData.size
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(myData: MyData) {
            with(itemView){
                Glide.with(itemView.context)
                    .load(myData.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(findViewById<CircleImageView>(R.id.img_item_photo))
                findViewById<TextView>(R.id.tv_item_name).text = myData.name
                findViewById<TextView>(R.id.tv_item_description).text = myData.description
            }
        }
    }
}
