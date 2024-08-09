package com.example.jetpackcompose.ui.screenexamples.roomnote2.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM task_table ORDER BY title DESC")
    fun getAllTasks(): Flow<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTaskEntity(taskEntity: TaskEntity)

    @Query("DELETE FROM task_table")
    suspend fun deleteAll()

    @Insert
    fun insertTask(taskEntity: TaskEntity)

    @Update
    suspend fun updateTask(taskEntity: TaskEntity)

    @Delete
    suspend fun deleteTask(taskEntity: TaskEntity)

    @Upsert
    suspend fun upsertTask(taskEntity: TaskEntity)

    @Query("DELETE FROM task_table WHERE isCompleted = 1")
    suspend fun deleteCompletedTasks()

}