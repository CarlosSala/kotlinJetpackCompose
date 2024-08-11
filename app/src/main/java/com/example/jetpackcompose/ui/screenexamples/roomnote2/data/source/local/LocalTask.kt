package com.example.jetpackcompose.ui.screenexamples.roomnote2.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class LocalTask(
    @PrimaryKey
    val id: String,
    var title: String,
    var description: String,
    val isCompleted: Boolean
)

