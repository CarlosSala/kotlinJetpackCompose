package com.example.jetpackcompose.ui.screenexamples.roomnote2.data

import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.model.Task
import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.source.local.TaskDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultRepository @Inject constructor(
    private val localDataSource: TaskDao
) : TaskRepository {

    override suspend fun createTask(title: String, description: String): String {

        val taskId = withContext(Dispatchers.IO) {
            UUID.randomUUID().toString()
        }
        val task = Task(
            title = title,
            description = description,
            id = taskId
        )
        localDataSource.upsert(task.toLocalTask())
        return taskId
    }

    override suspend fun updateTask(taskId: String, title: String, description: String) {

        val task = getTask(taskId)?.copy(
            title = title,
            description = description
        ) ?: throw Exception("Task (id $taskId) not found ")

        localDataSource.upsert(task.toLocalTask())
    }

    override suspend fun getTasks(forceUpdate: Boolean): List<Task> {
        if (forceUpdate) {
            refresh()
        }
        return withContext(Dispatchers.IO) {
            localDataSource.getAll().toExternal()
        }
    }

    override fun getTasksStream(): Flow<List<Task>> {
        return localDataSource.observeAll().map { tasks ->
            withContext(Dispatchers.IO) {
                tasks.toExternal()
            }
        }
    }

    override suspend fun refreshTask(taskId: String) {
        refresh()
    }

    override fun getTaskStream(taskId: String): Flow<Task?> {
        return localDataSource.observeById(taskId).map { it.toExternal() }
    }

    override suspend fun getTask(taskId: String, forceUpdate: Boolean): Task? {
        if (forceUpdate) {
            refresh()
        }
        return localDataSource.getById(taskId)?.toExternal()
    }

    override suspend fun completeTask(taskId: String) {
        localDataSource.updateCompleted(taskId = taskId, completed = true)
    }

    override suspend fun activateTask(taskId: String) {
        localDataSource.updateCompleted(taskId = taskId, completed = false)
    }

    override suspend fun clearCompletedTasks() {
        localDataSource.deleteCompleted()
    }

    override suspend fun deleteAllTasks() {
        localDataSource.deleteAll()
    }

    override suspend fun deleteTask(taskId: String) {
        localDataSource.deleteById(taskId)
    }

    override suspend fun refresh() {
        withContext(Dispatchers.IO) {
            localDataSource.deleteAll()
        }
    }
}