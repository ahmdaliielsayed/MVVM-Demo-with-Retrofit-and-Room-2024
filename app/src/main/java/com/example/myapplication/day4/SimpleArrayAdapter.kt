package com.example.myapplication.day4

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R

class SimpleArrayAdapter(
    private val context: Context,
    private val values: Array<String>,
    private val images: Array<Int>
) : ArrayAdapter<Any?>(context, R.layout.single_row, R.id.textView, values) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var rowView = convertView
        val viewHold: ViewHolder

        if (rowView == null) {
            // Inflate the layout
            val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            rowView = inflater.inflate(R.layout.single_row, parent, false)

            viewHold = ViewHolder(rowView)
            rowView.tag = viewHold
            Log.d("asd -> ", "first time --> inflation")
        } else {
            viewHold = rowView.tag as ViewHolder
            Log.d("asd -> ", "second time --> reuse")
        }

        // provide element (row) of the array with its position
        viewHold.getImage().setImageResource(images[position])
        viewHold.getDay().text = values[position]

        return rowView!!
    }

    class ViewHolder(val view: View) {
        private var day: TextView? = null
        private var image: ImageView? = null

        fun getDay(): TextView {
            return day ?: view.findViewById(R.id.textView)
        }

        fun getImage(): ImageView {
            return image ?: view.findViewById(R.id.imageView)
        }
    }
}