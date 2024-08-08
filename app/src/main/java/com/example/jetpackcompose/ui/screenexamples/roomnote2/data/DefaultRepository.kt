package com.example.jetpackcompose.ui.screenexamples.roomnote2.data

import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.model.Task
import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.source.local.TaskDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultRepository @Inject constructor(
    private val localDataSource: TaskDao
) : TaskRepository {

    override fun getTasksStream(): Flow<List<Task>> {
        return runBlocking {
            withContext(Dispatchers.IO) {
                localDataSource.getAllTasks().map { it.toExternal() }
            }
        }
    }

    override suspend fun createTask(title: String, description: String): String {

        val taskId = withContext(Dispatchers.IO) {
            UUID.randomUUID().toString()
        }
        val task = Task(
            title = title,
            description = description,
            id = taskId
        )
        localDataSource.upsertTask(task.toTaskEntity())
        return taskId
    }
}