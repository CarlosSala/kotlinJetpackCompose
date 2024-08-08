package com.example.jetpackcompose.ui.screenexamples.roomnote2.ui.tasksScreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.DefaultRepository
import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.TaskRepository
import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.model.Task
import com.example.jetpackcompose.ui.screenexamples.roomnote2.ui.util.FilteringUiInfo
import com.example.jetpackcompose.ui.screenexamples.roomnote2.ui.util.MyAsync
import com.example.jetpackcompose.ui.screenexamples.roomnote2.ui.util.TasksFilterType
import com.example.jetpackcompose.ui.screenexamples.roomnote2.ui.util.TasksUiState
import com.example.jetpackcompose.ui.screenexamples.roomnote2.ui.util.WhileUiSubscribed
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

/*class TaskViewModelFactory(
    private val application: Application,
    private val defaultRepository: DefaultRepository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TaskViewModel(application, defaultRepository, savedStateHandle) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}*/

// Used to save the current filtering in SavedStateHandle.
const val TASKS_FILTER_SAVED_STATE_KEY = "TASKS_FILTER_SAVED_STATE_KEY"

@HiltViewModel
class TaskViewModel @Inject constructor(
    application: Application,
    private val taskRepository: TaskRepository,
    savedStateHandle: SavedStateHandle
) : AndroidViewModel(application) {

    // first filter applied
    private val _savedFilterType = savedStateHandle.getStateFlow(
        TASKS_FILTER_SAVED_STATE_KEY,
        TasksFilterType.ALL_TASKS
    )

    // the value returned by _savedFilterType is passed to getFilterUiInfo
    private val _filterUiInfo = _savedFilterType.map { getFilterUiInfo(it) }.distinctUntilChanged()
    private val _userMessage: MutableStateFlow<Int?> = MutableStateFlow(null)
    private val _isLoading = MutableStateFlow(false)

    private val _filteredTaskMyAsync = combine(
        taskRepository.getTasksStream(),
        _savedFilterType
    ) { tasks, typeFilter ->

        filterTasks(tasks, typeFilter)
    } // revisar que hace el codigo
        .map { MyAsync.Success(it) }
        .catch<MyAsync<List<Task>>> { emit(MyAsync.Error(R.string.loading_tasks_error)) }

    val uiState: StateFlow<TasksUiState> = combine(
        _filterUiInfo,
        _isLoading,
        _userMessage,
        _filteredTaskMyAsync
    ) { filterUiInfo, isLoading, userMessage, filteredTaskMyAsync ->

        when (filteredTaskMyAsync) {
            MyAsync.Loading -> {
                TasksUiState(isLoading = true)
            }

            is MyAsync.Error -> {
                TasksUiState(userMessage = filteredTaskMyAsync.errorMessage)
            }

            is MyAsync.Success -> {
                TasksUiState(
                    items = filteredTaskMyAsync.data,
                    filteringUiInfo = filterUiInfo,
                    isLoading = isLoading,
                    userMessage = userMessage
                )
            }
        }
    }.stateIn(
        scope = viewModelScope,
        started = WhileUiSubscribed,
        initialValue = TasksUiState(isLoading = true)
    )


    private fun filterTasks(taskList: List<Task>, filterType: TasksFilterType): List<Task> {

        val taskToShow = ArrayList<Task>()

        for (task in taskList) {
            when (filterType) {
                TasksFilterType.ALL_TASKS -> {
                    taskToShow.add(task)
                }

                TasksFilterType.ACTIVE_TASKS -> {
                    if (task.isActive) taskToShow.add(task)
                }

                TasksFilterType.COMPLETED_TASKS -> {
                    if (task.isCompleted) taskToShow.add(task)
                }
            }
        }
        return taskToShow
    }

    private fun getFilterUiInfo(tasksFilterType: TasksFilterType): FilteringUiInfo {

        return when (tasksFilterType) {

            TasksFilterType.ALL_TASKS -> {

                FilteringUiInfo(
                    currentFilteringLabel = R.string.label_all,
                    noTasksLabel = R.string.no_tasks_all,
                    noTaskIconRes = R.drawable.logo_no_fill,
                )
            }

            TasksFilterType.ACTIVE_TASKS -> {
                FilteringUiInfo(
                    currentFilteringLabel = R.string.label_active,
                    noTasksLabel = R.string.no_tasks_active,
                    noTaskIconRes = R.drawable.ic_check_circle_96dp,
                )
            }

            TasksFilterType.COMPLETED_TASKS -> {
                FilteringUiInfo(
                    currentFilteringLabel = R.string.label_completed,
                    noTasksLabel = R.string.no_tasks_completed,
                    noTaskIconRes = R.drawable.ic_verified_user_96dp,
                )
            }
        }
    }


    /*
        val allTaskEntity: Flow<List<TaskEntity>>
    */

    /*    init {
            val taskEntityDao = TaskDatabase.getDatabase(application).getTaskDao()
            repository = TaskRepository(taskEntityDao)
            allTaskEntity = repository.allTaskEntity
        }*/


    /*    fun addTask(task: TaskEntity) {
            viewModelScope.launch {
                repository.insert(task)
            }
        }

        fun updateTask(task: TaskEntity) {
            viewModelScope.launch {
                repository.updateTask(task)
            }
        }

        fun deleteTask(task: TaskEntity) {
            viewModelScope.launch {
                repository.deleteTask(task)
            }
        }*/

    /*    private fun loadNotes() {
            viewModelScope.launch {
                _tasks.value = noteDao.getAllNotes()
            }
        }
        }*/

}