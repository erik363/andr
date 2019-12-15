package com.example.android.navigation.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.android.navigation.formatNights
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AdatbViewModel(
        val database: AdatbDAO,
        application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()


    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val matches = database.getAllMatch()

    val nightsString = Transformations.map(matches) { nights ->
        formatNights(nights, application.resources)
    }

    private var actual = MutableLiveData<Adatb?>()

    init {
        initializeTonight()
    }

    private fun initializeTonight() {
        uiScope.launch {
            actual.value = getTonightFromDatabase()
        }
    }

    private suspend fun getTonightFromDatabase(): Adatb? {

        return withContext(Dispatchers.IO) {

            var match = database.getLast()
            if (match?.endTimeMilli != match?.startTimeMilli) {
                match = null
            }
            match
        }
    }

    fun onStartTracking() {
        uiScope.launch {
            val newNight = Adatb()
            insert(newNight)
            actual.value = getTonightFromDatabase()
        }
    }

    private suspend fun insert(night: Adatb) {
        withContext(Dispatchers.IO) {
            database.insert(night)
        }
    }

    fun onStopTracking() {
        uiScope.launch {
            val oldNight = actual.value ?: return@launch
            oldNight.endTimeMilli = System.currentTimeMillis()
            update(oldNight)
        }
    }

    private suspend fun update(night: Adatb) {
        withContext(Dispatchers.IO) {
            database.update(night)
        }
    }

    fun onClear() {
        uiScope.launch {
            clear()
            actual.value = null
        }
    }

    suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}