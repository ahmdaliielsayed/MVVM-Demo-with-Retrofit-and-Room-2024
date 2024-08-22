package com.example.myapplication.day8

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.myapplication.R

class KabaddiKounterActivity : AppCompatActivity() {

    private lateinit var textViewScoreA: TextView
    private lateinit var textViewScoreB: TextView
    private lateinit var textViewResult: TextView
    private lateinit var btnAPlusOne: Button
    private lateinit var btnAPlusTwo: Button
    private lateinit var btnBPlusOne: Button

    private val viewModel: ScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kabaddi_kounter)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initializeUIComponents()
        handleButtonsClick()
        handleObservation()
    }

    private fun initializeUIComponents() {
        textViewScoreA = findViewById(R.id.textView_scoreA)
        btnAPlusOne = findViewById(R.id.btn_a_plus_one)
        btnAPlusTwo = findViewById(R.id.btn_a_plus_two)

        textViewScoreB = findViewById(R.id.textView_scoreB)
        btnBPlusOne = findViewById(R.id.btn_b_plus_one)

        textViewResult = findViewById(R.id.textView_result)
    }

    private fun handleButtonsClick() {
        btnAPlusOne.setOnClickListener {
            viewModel.incrementScore(isTeamA = true)
//            textViewScoreA.text = viewModel.scoreA.toString()
        }

        btnAPlusTwo.setOnClickListener {
            viewModel.incrementScoreByTwo(isTeamA = true)
//            textViewScoreA.text = viewModel.scoreA.toString()
        }

        btnBPlusOne.setOnClickListener {
            viewModel.incrementScore(isTeamA = false)
            textViewScoreB.text = viewModel.scoreB.toString()
        }
    }

    private fun handleObservation() {
        /*val scoreAObserver = Observer<Int> { newScore ->
            textViewScoreA.text = newScore.toString()
        }*/
        /*viewModel.scoreA.observe(this, Observer<Int> { newScore ->
            textViewScoreA.text = newScore.toString()
        })*/
        /*viewModel.scoreA.observe(this, { newScore ->
            textViewScoreA.text = newScore.toString()
        })*/
        viewModel.scoreA.observe(this) { newScore ->
            textViewScoreA.text = newScore.toString()
        }

        viewModel.resultA.observe(this) { resultValue ->
            textViewResult.text = resultValue
        }
    }
}