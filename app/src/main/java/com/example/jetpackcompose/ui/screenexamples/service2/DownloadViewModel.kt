package com.example.jetpackcompose.ui.screenexamples.service2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DownloadViewModel : ViewModel() {

    private val _progress = MutableStateFlow(0) // Estado del progreso
    val progress: StateFlow<Int> = _progress

    // state for notification permission
    private val _hasNotificationPermission = MutableStateFlow(false)
    val hasNotificationPermission: StateFlow<Boolean> = _hasNotificationPermission

    init {
        // listener for progress from service
        viewModelScope.launch {
            DownloadService.Companion.progressFlow.collect { newProgress ->
                _progress.value = newProgress
            }
        }
    }

    fun updateNotificationPermission(granted: Boolean) {
        viewModelScope.launch {
            _hasNotificationPermission.value = granted
        }
    }
}
