package com.example.jetpackcompose.ui.screenexamples.worker3

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OneTimeWorkViewModel(application: Application) : AndroidViewModel(application) {

    private val _uploadState = MutableStateFlow(UploadState.Idle)
    val uploadState: StateFlow<UploadState> = _uploadState

    suspend fun uploadRequest() {

        val uploadRequest = OneTimeWorkRequestBuilder<OneTimeWorkRequest>()
            .build()

        val workManager = WorkManager.getInstance(getApplication<Application>().applicationContext)
        workManager.enqueue(uploadRequest)

        workManager.getWorkInfoByIdFlow(uploadRequest.id)
            .collect {
                when (it.state) {
                    WorkInfo.State.SUCCEEDED -> _uploadState.value = UploadState.Success
                    WorkInfo.State.RUNNING -> _uploadState.value = UploadState.Uploading
                    WorkInfo.State.FAILED -> _uploadState.value = UploadState.Error
                    WorkInfo.State.ENQUEUED -> _uploadState.value = UploadState.Idle
                    WorkInfo.State.BLOCKED -> _uploadState.value = UploadState.Idle
                    WorkInfo.State.CANCELLED -> _uploadState.value = UploadState.Idle
                }
            }
    }
}

enum class UploadState {
    Idle, Uploading, Success, Error
}