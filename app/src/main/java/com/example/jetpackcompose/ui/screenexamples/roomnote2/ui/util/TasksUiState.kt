package com.example.jetpackcompose.ui.screenexamples.roomnote2.ui.util

import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.model.Task


/**
 * UiState for the task list screen.
 */
data class TasksUiState(
    val items: List<Task> = emptyList(),
    val isLoading: Boolean = false,
    val filteringUiInfo: FilteringUiInfo = FilteringUiInfo(),
    val userMessage: Int? = null,
)