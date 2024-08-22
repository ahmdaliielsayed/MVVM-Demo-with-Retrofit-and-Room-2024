package com.example.myapplication.day5

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R

class DynamicFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("asd ->", "Fragment -> onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("asd ->", "Fragment -> onCreateView()")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dynamic, container, false)
    }
}