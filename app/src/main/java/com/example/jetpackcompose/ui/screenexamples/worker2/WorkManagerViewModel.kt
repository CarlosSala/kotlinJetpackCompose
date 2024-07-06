package com.example.jetpackcompose.ui.screenexamples.worker2
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.*
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class WorkManagerViewModel(application: Application) : AndroidViewModel(application) {

    private val workManager = WorkManager.getInstance(application)

    private val workRequest = PeriodicWorkRequestBuilder<MyPeriodicWorker>(15, TimeUnit.MINUTES)
        .build()

    fun startWorker() {
        viewModelScope.launch {
            workManager.enqueueUniquePeriodicWork(
                "MyPeriodicWork",
                ExistingPeriodicWorkPolicy.REPLACE,
                workRequest
            )
        }
    }

    fun stopWorker() {
        viewModelScope.launch {
            workManager.cancelUniqueWork("MyPeriodicWork")
        }
    }
}
