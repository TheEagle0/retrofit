package com.example.theeagle.appexample.adapter

import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.theeagle.appexample.R
import com.example.theeagle.appexample.entity.DataEntity

class Adapter(val items: List<DataEntity>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val list = items[p1]
        p0.title.text = list.articleName
        p0.section.text = list.section
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: AppCompatTextView = itemView.findViewById(R.id.title)
        val section: AppCompatTextView = itemView.findViewById(R.id.section)

    }
}