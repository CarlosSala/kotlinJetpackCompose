package com.example.jetpackcompose.ui.screenexamples.worker2

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.*

class MyPeriodicWorker(appContext: Context, workerParams: WorkerParameters) :
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
}
