package com.example.myapplication.day8

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {

    private val _scoreA = MutableLiveData<Int>(0)
    val scoreA: LiveData<Int>
        get() = _scoreA

//    var scoreA: Int = 0
    var scoreB: Int = 0

    fun incrementScore(isTeamA: Boolean) {
        if (isTeamA) {
//            scoreA++
            _scoreA.value = _scoreA.value!! + 1

        } else {
            scoreB++
        }
    }

    fun incrementScoreByTwo(isTeamA: Boolean) {
        if (isTeamA) {
//            scoreA++
            _scoreA.value = _scoreA.value!! + 2

        } else {
            scoreB++
        }
    }

    val resultA: LiveData<String> = _scoreA.map { score ->
        if (score > 10)
            "Team A WINS"
        else
            ""
    }

    private fun <X, Y> LiveData<X>.map(transform: (X) -> Y): LiveData<Y> {
        val result = MediatorLiveData<Y>()
        result.addSource(this) { x ->
            result.value = transform(x)
        }

        return result
    }
}