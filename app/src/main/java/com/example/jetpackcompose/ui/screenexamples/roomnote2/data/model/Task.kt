package com.example.jetpackcompose.ui.screenexamples.roomnote2.data.model

data class Task(
    val title: String = "",
    val description: String = "",
    val isCompleted: Boolean = false,
    val id: String,
) {

    val isActive
        get() = !isCompleted
}