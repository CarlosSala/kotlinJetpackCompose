package com.example.jetpackcompose.ui.screenexamples.worker3

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class OneTimeWorkRequest(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {

        for (i: Int in 0..6000) {
            Log.i("MyTag", "Uploading $i")
        }
        return Result.success()
    }
}