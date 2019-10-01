package com.example.android_sprint3_challenge.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_sprint3_challenge.R
import com.example.android_sprint3_challenge.model.Pokemon
import kotlinx.android.synthetic.main.list_item.view.*


import kotlin.collections.ArrayList


class Adapter (val list: MutableList<Pokemon>): RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.text_view_tem

        fun bind(item: Pokemon) = with(itemView) {
           textView.text = item.name
            setOnClickListener {
                // TODO: Handle on click
            }
        }
    }

    private var data: List<Pokemon> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = list[position].name
    }



    /*updates changes in RecyclerView*/

    fun swapData(data: List<Pokemon>) {
        this.data = data
        notifyDataSetChanged()
    }


}