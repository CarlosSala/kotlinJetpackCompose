package com.example.jetpackcompose.ui.screenexamples.roomnote2

import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {

    val allTaskEntity: Flow<List<TaskEntity>> = taskDao.getAllTasks()

    suspend fun insert(taskEntity: TaskEntity) {
        taskDao.insertTaskEntity(taskEntity)
    }

    suspend fun updateTask(taskEntity: TaskEntity){
        taskDao.updateTask(taskEntity)
    }

    suspend fun deleteTask(taskEntity: TaskEntity){
        taskDao.deleteTask(taskEntity)
    }
}
