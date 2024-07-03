package com.example.jetpackcompose.ui.screenexamples.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_entities")
data class NoteEntity(
    val noteName: String,
    val noteBody: String,
    @PrimaryKey(autoGenerate = true)
    val noteId: Int = 0,
)
