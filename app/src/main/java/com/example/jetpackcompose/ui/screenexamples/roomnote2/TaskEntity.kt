package com.example.jetpackcompose.ui.screenexamples.roomnote2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class TaskEntity(
    var title: String,
    var description: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    // val isCompleted: Boolean = false
)

