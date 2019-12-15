package com.example.android.navigation

import android.app.Application
import android.content.Context
import android.os.CountDownTimer
import android.util.Log
import android.widget.GridLayout
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.navigation.database.AdatbDAO

class GameViewModel() : ViewModel() {

    val boardC = Array(3){ arrayOfNulls<ImageView>(3)}
    var next = 0
    var board = Board()

    //LiveData
    private val _score = MutableLiveData<Int>()
    val score:LiveData<Int>
        get() = _score

//LiveData transformation
    companion object {

        // Time when the game is over
        private const val DONE = 0L

        // Countdown time interval
        private const val ONE_SECOND = 1000L

        // Total time for the game
        private const val COUNTDOWN_TIME = 60000L
    }

    private val _currentTime = MutableLiveData<Long>()
    val currentTime: LiveData<Long>
        get() = _currentTime

    private val timer: CountDownTimer
//////
    init {
        Log.i("GameViewModel", "GameViewModel created!")
        _score.value = 9

        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {

        override fun onTick(millisUntilFinished: Long) {
            _currentTime.value = millisUntilFinished/ONE_SECOND
        }

        override fun onFinish() {
            _currentTime.value = DONE
           // onGameFinish()
        }
    }

    timer.start()
    }



    fun updateScoreText() {
        _score.value = (score.value)?.minus(1)
    }



}