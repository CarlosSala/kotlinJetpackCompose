package com.example.jetpackcompose.ui.screenexamples.roomnote2.data

import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.model.Task
import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.source.local.LocalTask

// external to local
fun Task.toTaskEntity() = LocalTask(
    id = id,
    title = this.title,
    description = this.description,
    isCompleted = this.isCompleted
)


// local to External

fun LocalTask.toExternal() = Task(
    id = this.id.toString(),
    title = this.title,
    description = this.description,
    isCompleted = this.isCompleted
)

@JvmName("localToExternal")
fun List<LocalTask>.toExternal() = map(LocalTask::toExternal)