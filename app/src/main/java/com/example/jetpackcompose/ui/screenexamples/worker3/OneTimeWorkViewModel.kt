package com.example.jetpackcompose.ui.screenexamples.worker3

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OneTimeWorkViewModel(application: Application) : AndroidViewModel(application) {

    companion object {
        const val KEY_COUNT_VALUE = "key_count"
    }

    private val _uploadState = MutableStateFlow(UploadState.Idle)
    val uploadState: StateFlow<UploadState> = _uploadState

    private val _state = MutableStateFlow<Data?>(null)
    val state: StateFlow<Data?> = _state

    suspend fun uploadRequest() {

        val workManager = WorkManager.getInstance(getApplication<Application>().applicationContext)

        // constraints
        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        // input and output
        val data: Data = Data.Builder()
            .putInt(KEY_COUNT_VALUE, 5)
            .build()

        val uploadRequest = OneTimeWorkRequestBuilder<OneTimeWorkRequest>()
            .setConstraints(constraints)
            .setInputData(data)
            .build()
        workManager.enqueue(uploadRequest)

        workManager.getWorkInfoByIdFlow(uploadRequest.id)
            .collect {
                when (it.state) {
                    WorkInfo.State.SUCCEEDED -> {
                        _uploadState.value = UploadState.Success
                        if (it.state.isFinished) _state.value = it.outputData
                    }

                    WorkInfo.State.RUNNING -> {
                        _uploadState.value = UploadState.Uploading
                        _state.value = it.outputData
                    }

                    WorkInfo.State.FAILED -> {
                        _uploadState.value = UploadState.Error
                        _state.value = it.outputData
                    }

                    WorkInfo.State.ENQUEUED -> {
                        _uploadState.value = UploadState.Idle
                        _state.value = it.outputData
                    }

                    WorkInfo.State.BLOCKED -> {
                        _uploadState.value = UploadState.Idle
                        _state.value = it.outputData
                    }

                    WorkInfo.State.CANCELLED -> {
                        _uploadState.value = UploadState.Idle
                        _state.value = it.outputData
                    }
                }
            }
    }
}

enum class UploadState {
    Idle, Uploading, Success, Error
}