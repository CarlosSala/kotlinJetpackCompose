package com.example.jetpackcompose.ui.screenexamples.roomnote2.data

import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.model.Task
import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.source.local.TaskEntity

// external to local
fun Task.toTaskEntity() = TaskEntity(
    id = id,
    title = this.title,
    description = this.description,
    isCompleted = this.isCompleted
)


// local to External

fun TaskEntity.toExternal() = Task(
    id = this.id.toString(),
    title = this.title,
    description = this.description,
    isCompleted = this.isCompleted
)

@JvmName("localToExternal")
fun List<TaskEntity>.toExternal() = map(TaskEntity::toExternal)