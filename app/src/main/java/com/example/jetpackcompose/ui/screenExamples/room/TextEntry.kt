package com.example.jetpackcompose.ui.screenExamples.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "text_entries")
data class TextEntry(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val text: String
)
