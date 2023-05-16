package com.elsa.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IdolAdapter(private val context: Context, val IdolList: ArrayList<Idol>, val listener: (Idol) -> Unit): RecyclerView.Adapter<IdolAdapter.IdolViewHolder>(){
    class IdolViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val imgIdol : ImageView = itemView.findViewById(R.id.img_item_photo)
        val nameIdol : TextView =  itemView.findViewById(R.id.tv_item_name)
        val descIdol : TextView = itemView.findViewById(R.id.tv_item_description)

        fun bindView(idol: Idol, listener: (Idol) -> Unit){imgIdol.setImageResource(idol.imgIdol)

            nameIdol.text = idol.nameIdol
            descIdol.text = idol.descIdol
            itemView.setOnClickListener{
                listener(idol)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IdolViewHolder{
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_idol, parent, false)
        return IdolViewHolder(itemView)}

    override fun onBindViewHolder(holder: IdolViewHolder, position: Int) {
        val currentItem = IdolList[position]

        holder.imgIdol.setImageResource(currentItem.imgIdol)

        holder.nameIdol.text = (currentItem.nameIdol)
        holder.descIdol.text = (currentItem.descIdol)
        holder.bindView(IdolList[position], listener)

    }

    override fun getItemCount(): Int {
        return IdolList.size
    }



}