package com.example.jetpackcompose.ui.screenExamples.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteEntity(
    val noteName: String,
    val noteBody: String,
    @PrimaryKey(autoGenerate = true)
    val noteId: Int = 0,
)
