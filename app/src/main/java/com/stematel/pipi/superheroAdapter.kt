package com.stematel.recylerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stematel.pipi.R

class superheroAdapter (private val context: Context, private val superhero: List<Superhero>, val listener: (Superhero) -> Unit)
    : RecyclerView.Adapter<superheroAdapter.SuperheroViewHolder>(){
    class SuperheroViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val imgsuperhero = view.findViewById<ImageView>(R.id.img_item_photo)
        val namesuperhero = view.findViewById<TextView>(R.id.tv_item_bab)

        fun bindView(superhero: Superhero, listener: (Superhero) -> Unit){
            imgsuperhero.setImageResource(superhero.imgsuperhero)
            namesuperhero.text = superhero.namesuperhero
            itemView.setOnClickListener{
                listener(superhero)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        return SuperheroViewHolder(
            LayoutInflater.from(context).inflate(R.layout.recycleview_bab, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        holder.bindView(superhero[position],listener)
    }

    override fun getItemCount(): Int = superhero.size
}