package com.example.jetpackcompose.ui.screenexamples.worker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import androidx.work.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

const val uniqueWorkName = "MyPeriodicWork"

class MyPeriodicWorkerViewModel(application: Application) : AndroidViewModel(application) {

    private val workManager = WorkManager.getInstance(application)

    private val workRequest = PeriodicWorkRequestBuilder<MyPeriodicWorker>(
        repeatInterval = 15,
        repeatIntervalTimeUnit = TimeUnit.MINUTES
    ).build()

    private val _isWorkerRunning = MutableStateFlow(false)
    val isWorkerRunning: StateFlow<Boolean> get() = _isWorkerRunning

    init {
        updateWorkerStatus()
    }

    private fun updateWorkerStatus() {
        viewModelScope.launch {
            val workInfos = workManager.getWorkInfosForUniqueWorkLiveData(uniqueWorkName).asFlow()
            workInfos.collect { infoList ->
                _isWorkerRunning.value = infoList.any {
                    it.state == WorkInfo.State.ENQUEUED || it.state == WorkInfo.State.RUNNING
                }
            }
        }
    }

    fun startWorker() {
        viewModelScope.launch {
            workManager.enqueueUniquePeriodicWork(
                uniqueWorkName,
                ExistingPeriodicWorkPolicy.REPLACE,
                workRequest
            )
            updateWorkerStatus()
        }
    }

    fun stopWorker() {
        viewModelScope.launch {
            workManager.cancelUniqueWork(uniqueWorkName)
            updateWorkerStatus()
        }
    }
}
