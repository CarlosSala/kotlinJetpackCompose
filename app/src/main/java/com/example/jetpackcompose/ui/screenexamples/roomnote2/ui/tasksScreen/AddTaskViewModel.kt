package com.example.jetpackcompose.ui.screenexamples.roomnote2.ui.tasksScreen

import android.app.ActivityManager.TaskDescription
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.ui.screenexamples.roomnote2.TaskDestinationsArgs
import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AddTaskUiState(
    val title: String = "",
    val description: String = "",
    val isTaskCompleted: Boolean = false,
    val isLoading: Boolean = false,
    val userMessage: Int? = null,
    val isTaskSaved: Boolean = false
)

@HiltViewModel
class AddTaskViewModel @Inject constructor(
    private val taskRepository: TaskRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val taskId: String? = savedStateHandle[TaskDestinationsArgs.TASK_ID_ARG]

    private val _uiState = MutableStateFlow(AddTaskUiState())
    val uiState: StateFlow<AddTaskUiState> = _uiState.asStateFlow()

    fun saveTask() {

        if (taskId == null) {
            createNewTask()
        }
    }

    private fun createNewTask() = viewModelScope.launch {
        taskRepository.createTask(_uiState.value.title, _uiState.value.description)
        _uiState.update {
            it.copy(isTaskSaved = true)
        }
    }

    fun updateTitle(newTitle: String) {
        _uiState.update {
            it.copy(title = newTitle)
        }
    }

    fun updateDescription(newDescription: String) {
        _uiState.update {
            it.copy(title = newDescription)
        }
    }
}