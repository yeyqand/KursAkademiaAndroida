package com.yeyq.kursakademiaandroida.core.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val items by lazy { mutableListOf<T>() }

    fun setItems(items: List<T>) {
        if (items.isNotEmpty()) {
            this.items.clear()
        }

        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return onCreateViewHolderBase(parent, viewType)
    }

    abstract fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBindViewHolderBase(holder, position)
    }

    abstract fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int)

    override fun getItemCount(): Int = items.size
}