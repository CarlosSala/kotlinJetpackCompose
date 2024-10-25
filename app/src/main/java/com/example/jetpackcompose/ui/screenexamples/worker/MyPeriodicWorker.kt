package com.example.jetpackcompose.ui.screenexamples.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.*

class MyPeriodicWorker(appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {

    var counter = 0
    override suspend fun doWork(): Result {
        val job = CoroutineScope(Dispatchers.IO).launch {
            repeat(30) {
                if (isStopped) {
                    return@launch
                }
                delay(1000)
                Log.d("my worker", "Message from my periodic worker ${counter++}")
            }
        }

        job.join()

        return Result.success()
    }
}