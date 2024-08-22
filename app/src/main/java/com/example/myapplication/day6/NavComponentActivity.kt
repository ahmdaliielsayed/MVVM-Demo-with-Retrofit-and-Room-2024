package com.example.myapplication.day6

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import com.example.myapplication.R

class NavComponentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nav_component)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnNavigateFromActivity = findViewById<Button>(R.id.btn_navigate_from_activity)
        btnNavigateFromActivity.setOnClickListener {
            val navController = findNavController(R.id.nav_host)
            navController.navigate(R.id.action_welcomeFragment_to_detailsFragment)
        }
    }
}