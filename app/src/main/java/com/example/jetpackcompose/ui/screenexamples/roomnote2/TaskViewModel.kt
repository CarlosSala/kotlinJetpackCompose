package com.example.jetpackcompose.ui.screenexamples.roomnote2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TaskRepository

    val allTaskEntity: Flow<List<TaskEntity>>

    init {
        val taskEntityDao = TaskDatabase.getDatabase(application).getTaskDao()
        repository = TaskRepository(taskEntityDao)
        allTaskEntity = repository.allTaskEntity
    }


    fun addTask(task: TaskEntity) {
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
    }

    /*    private fun loadNotes() {
            viewModelScope.launch {
                _tasks.value = noteDao.getAllNotes()
            }
        }
        }*/
}