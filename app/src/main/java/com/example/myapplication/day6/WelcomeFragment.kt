package com.example.myapplication.day6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnNavigateFromFragment = view.findViewById<Button>(R.id.btn_navigate_from_fragment)
        btnNavigateFromFragment.setOnClickListener {
//            findNavController().navigate(R.id.action_welcomeFragment_to_detailsFragment)

            val name = "Ahmed Ali"
            val streetNo = 15

            val action =
                WelcomeFragmentDirections.actionWelcomeFragmentToDetailsFragment(name, streetNo)
            findNavController().navigate(action)
        }
    }
}