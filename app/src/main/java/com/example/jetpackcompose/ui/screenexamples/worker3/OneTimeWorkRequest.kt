package com.example.jetpackcompose.ui.screenexamples.worker3

import android.content.Context
import android.icu.text.SimpleDateFormat
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.jetpackcompose.ui.screenexamples.worker3.OneTimeWorkViewModel.Companion.KEY_COUNT_VALUE
import java.util.Date

class OneTimeWorkRequest(context: Context, params: WorkerParameters) : Worker(context, params) {

    companion object {
        const val KEY_WORKER = "key_worker"
    }

    override fun doWork(): Result {

        try {
            val count = inputData.getInt(KEY_COUNT_VALUE, 0)
            for (i: Int in 0..count) {
                Log.i("MyTag", "Uploading $i")
            }
            val time = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = time.format(Date())
            val outPutDate = Data.Builder().putString(KEY_WORKER, currentDate).build()
            return Result.success(outPutDate)
        } catch (e: Exception) {
            return Result.failure()
        }
    }
}