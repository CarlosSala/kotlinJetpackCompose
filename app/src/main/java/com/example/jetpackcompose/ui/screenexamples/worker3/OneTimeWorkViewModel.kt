package com.example.jetpackcompose.ui.screenexamples.worker3

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class OneTimeWorkViewModel(application: Application) : AndroidViewModel(application) {

    fun uploadRequest() {

        val uploadRequest = OneTimeWorkRequestBuilder<OneTimeWorkRequest>()
            .build()

        val workManager = WorkManager.getInstance(getApplication<Application>().applicationContext)
        workManager.enqueue(uploadRequest)
    }
}