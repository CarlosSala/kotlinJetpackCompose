package com.example.jetpackcompose.ui.screenexamples.worker

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class ImageUploadViewModel(application: Application) : AndroidViewModel(application) {

    private val workManager = WorkManager.getInstance(application)

    fun uploadImage(imageUri: Uri) {
        val data = Data.Builder()
            .putString("imageUri", imageUri.toString())
            .build()

        val uploadWorkRequest = OneTimeWorkRequestBuilder<UploadWorker>()
            .setInputData(data)
            .build()

        workManager.enqueue(uploadWorkRequest)
    }
}
