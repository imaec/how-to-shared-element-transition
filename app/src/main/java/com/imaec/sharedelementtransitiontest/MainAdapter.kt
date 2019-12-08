package com.imaec.sharedelementtransitiontest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_main.view.*

class MainAdapter(val itemClick: (String, View) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val listItem = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            holder.onBind(listItem[position])
        }
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textView by lazy { itemView.textView }
        private val imageView by lazy { itemView.imageView }

        fun onBind(item: String) {
            textView.text = item

            itemView.setOnClickListener { itemClick(item, imageView) }
        }
    }

    fun addItem(item: String) {
        listItem.add(item)
    }
}