package com.example.homework6

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class WorkViewModel : ViewModel() {

    val progress = MutableLiveData(0)
    val isWorking = MutableLiveData(false)
    val isFinished = MutableLiveData(false)

    private var job: Job? = null

    fun startWork() {
        isWorking.value = true
        isFinished.value = false
        progress.value = 0

        job = CoroutineScope(Dispatchers.Default).launch {
            for (i in 1..100) {
                delay(100)
                progress.postValue(i)
            }
            isWorking.postValue(false)
            isFinished.postValue(true)
        }
    }

    fun cancelWork() {
        job?.cancel()
        isWorking.value = false
        isFinished.value = false
        progress.value = 0
    }
}
