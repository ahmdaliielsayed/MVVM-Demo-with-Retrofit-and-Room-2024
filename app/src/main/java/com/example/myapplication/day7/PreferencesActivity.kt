package com.example.myapplication.day7

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R

class PreferencesActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private var highScore = 0
    private lateinit var textViewScore: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preferences)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textViewScore = findViewById(R.id.text_score)

        sharedPreferences = getSharedPreferences("File Name", MODE_PRIVATE)
    }

    override fun onStart() {
        super.onStart()

        highScore = sharedPreferences.getInt("high_score_key", 0)
        textViewScore.text = "New Score = $highScore"
    }

    override fun onPause() {
        super.onPause()

//        highScore++

        with(sharedPreferences.edit()) {
//            putInt("high_score_key", highScore)
            clear()
            apply()
        }
    }
}