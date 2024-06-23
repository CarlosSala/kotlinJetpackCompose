package com.example.jetpackcompose.ui.screenExamples.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [NoteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao
}