package com.example.myapplication.day4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    // 1. define data source
    val days: Array<Day> = arrayOf(
        Day("Saturday", R.drawable.one),
        Day("Sunday", R.drawable.two),
        Day("Monday", R.drawable.three),
        Day("Tuesday", R.drawable.four),
        Day("Wednesday", R.drawable.five),
        Day("Thursday", R.drawable.six),
        Day("Friday", R.drawable.seven),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        // 2. Tell adapter how to display data
//        val adapter: ArrayAdapter<String> = ArrayAdapter(applicationContext, R.layout.single_row, R.id.textView, values)
//        val adapter = SimpleArrayAdapter(this, values, images)
        val adapter = MyAdapter(days)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
    }
}