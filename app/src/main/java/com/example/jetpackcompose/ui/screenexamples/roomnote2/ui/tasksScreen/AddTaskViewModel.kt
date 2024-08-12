package com.example.jetpackcompose.ui.screenexamples.roomnote2.ui.tasksScreen

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

    // private val taskId: String? = savedStateHandle[TaskDestinationsArgs.TASK_ID_ARG]

    private var _taskId: String? = null

    private val _uiState = MutableStateFlow(AddTaskUiState())
    val uiState: StateFlow<AddTaskUiState> = _uiState.asStateFlow()

    fun setTaskId(taskId: String) {
        _taskId = taskId
    }

    fun saveTask() {

        if (_taskId == null || _taskId == "") {
            createNewTask()
        } else {
            updateTask()
        }
    }

    private fun createNewTask() = viewModelScope.launch {
        taskRepository.createTask(
            title = uiState.value.title,
            description = uiState.value.description
        )
        _uiState.update {
            it.copy(isTaskSaved = true)
        }
    }

    private fun updateTask() {
        if (_taskId == null) {
            throw RuntimeException("updateTask() was called but task is new.")
        } else {
            viewModelScope.launch {
                taskRepository.updateTask(
                    taskId = _taskId!!,
                    title = uiState.value.title,
                    description = uiState.value.description
                )
                _uiState.update {
                    it.copy(isTaskSaved = true)
                }
            }
            _taskId = ""
        }
    }

    private fun loadTask(taskId: String) {
        _uiState.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
            taskRepository.getTask(taskId = taskId).let { task ->
                if (task != null) {
                    _uiState.update {
                        it.copy(
                            title = task.title,
                            description = task.description,
                            isTaskCompleted = task.isCompleted,
                            isLoading = false
                        )
                    }
                } else {
                    _uiState.update {
                        it.copy(isLoading = false)
                    }
                }
            }
        }
    }


    fun updateTitle(newTitle: String) {
        _uiState.update {
            it.copy(title = newTitle)
        }
    }

    fun updateDescription(newDescription: String) {
        _uiState.update {
            it.copy(description = newDescription)
        }
    }

    fun deleteTask(myTaskId: String) = viewModelScope.launch {
        taskRepository.deleteTask(myTaskId)
    }
}