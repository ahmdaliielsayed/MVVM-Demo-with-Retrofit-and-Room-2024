package com.example.myapplication.day4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MyAdapter(private val days: Array<Day>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.single_row, parent, false)
        return ViewHolder(layout)
    }

    override fun getItemCount() = days.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.day.text = days[position].day
        holder.image.setImageResource(days[position].image)
    }

    class ViewHolder(private val row: View): RecyclerView.ViewHolder(row) {
        var day: TextView = row.findViewById(R.id.textView)
        var image: ImageView = row.findViewById(R.id.imageView)
    }
}