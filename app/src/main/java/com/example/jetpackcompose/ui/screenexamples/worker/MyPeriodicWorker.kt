package com.example.jetpackcompose.ui.screenexamples.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.*

class MyPeriodicWorker(appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        val job = CoroutineScope(Dispatchers.IO).launch {
            repeat(60) {
                if (isStopped) {
                    return@launch
                }
                delay(1000)
                Log.d("my worker", "Message from my periodic worker")
            }
        }

        job.join()

        return Result.success()
    }
}

// this is not going to finish at least that the work will be complete

/*class MyPeriodicWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {

        val job = CoroutineScope(Dispatchers.IO).launch {
            repeat(60) {
                delay(1000)
                Log.d("my worker", "Message from my periodic worker")
            }
        }

        // Espera a que termine el coroutine antes de continuar
        runBlocking {
            job.join()
        }

        return Result.success()
    }
}*/
