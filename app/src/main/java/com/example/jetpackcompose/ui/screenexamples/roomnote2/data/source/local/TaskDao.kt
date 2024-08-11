package com.example.jetpackcompose.ui.screenexamples.roomnote2.data.source.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

// Data Access Object for the task table
@Dao
interface TaskDao {

    // observes list of tasks
    @Query("SELECT * FROM task_table ORDER BY title DESC")
    fun observeAll(): Flow<List<LocalTask>>

    // observes a single task
    @Query("SELECT * FROM task_table WHERE id = :taskId")
    fun observeById(taskId: String): Flow<LocalTask>

    // select all task from the task table
    @Query("SELECT * FROM task_table")
    suspend fun getAll(): List<LocalTask>

    // select task by id
    @Query("SELECT * FROM task_table WHERE id = :taskId")
    suspend fun getById(taskId: String): LocalTask?

    // insert or update task. If a task already exits, replace it
    @Upsert
    suspend fun upsert(localTask: LocalTask)

    // insert or update tasks. If a task already exits, replace it
    @Upsert
    suspend fun upsertAll(localTask: List<LocalTask>)

    // update the complete status of a task
    @Query("UPDATE task_table SET isCompleted = :completed WHERE id = :taskId")
    suspend fun updateCompleted(taskId: String, completed: Boolean)

    // delete a task by id
    // return, the number of tasks deleted. This should always be 1.
    @Query("DELETE FROM task_table WHERE id =:taskId")
    suspend fun deleteById(taskId: String): Int

    // delete all tasks
    @Query("DELETE FROM task_table")
    suspend fun deleteAll()

    // delete all completed tasks from the table
    // return, the number or tasks deleted
    @Query("DELETE FROM task_table WHERE isCompleted = 1")
    suspend fun deleteCompleted(): Int

}