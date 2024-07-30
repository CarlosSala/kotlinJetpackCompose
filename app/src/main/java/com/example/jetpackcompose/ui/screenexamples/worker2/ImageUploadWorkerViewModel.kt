package com.example.jetpackcompose.ui.screenexamples.worker2

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.workDataOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ImageUploadWorkerViewModel(application: Application) : AndroidViewModel(application) {

    private val _uploadState = MutableStateFlow(UploadState.Idle)
    val uploadState: StateFlow<UploadState> get() = _uploadState

    fun uploadImage(uri: Uri) {
        val inputData = workDataOf("imageUri" to uri.toString())

        val uploadWorkRequest = OneTimeWorkRequestBuilder<ImageUploadWorker>()
            .setInputData(inputData)
            .build()

        WorkManager.getInstance(getApplication<Application>().applicationContext)
            .enqueue(uploadWorkRequest)

        // Listen for the status of the work
        WorkManager.getInstance(getApplication<Application>().applicationContext)
            .getWorkInfoByIdLiveData(uploadWorkRequest.id)
            .observeForever { workInfo ->
                when (workInfo.state) {
                    WorkInfo.State.SUCCEEDED -> _uploadState.value = UploadState.Success
                    WorkInfo.State.FAILED -> _uploadState.value = UploadState.Error
                    WorkInfo.State.RUNNING -> _uploadState.value = UploadState.Uploading
                    else -> _uploadState.value = UploadState.Idle
                }
            }
    }
}


/*class ImageUploadWorkerViewModel(application: Application) : AndroidViewModel(application) {

    private val workManager = WorkManager.getInstance(application)

    fun uploadImage(imageUri: Uri) {
        val data = Data.Builder()
            .putString("imageUri", imageUri.toString())
            .build()

        val uploadWorkRequest = OneTimeWorkRequestBuilder<ImageUploadWorker>()
            .setInputData(data)
            .build()

        workManager.enqueue(uploadWorkRequest)
    }
}*/
