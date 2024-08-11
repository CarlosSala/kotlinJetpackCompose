package com.example.jetpackcompose.ui.screenexamples.roomnote2.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [LocalTask::class],
    version = 1,
    exportSchema = false
)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao
}