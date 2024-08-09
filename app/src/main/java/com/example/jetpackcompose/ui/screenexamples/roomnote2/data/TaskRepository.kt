package com.example.jetpackcompose.ui.screenexamples.roomnote2.data

import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    fun getTasksStream(): Flow<List<Task>>

    suspend fun createTask(title: String, description: String): String

    suspend fun clearCompletedTask()

    suspend fun refresh()

    suspend fun completeTask(taskId: String)

    suspend fun activateTask(taskId: String)

}


/*class TaskRepository(private val taskDao: TaskDao) {

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
}*/
