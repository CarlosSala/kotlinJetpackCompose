package com.example.jetpackcompose.ui.screenexamples.roomnote2.ui.util

// Used with the filter spinner in the tasks list.
enum class TasksFilterType {

    // Do not filter tasks.
    ALL_TASKS,

    // Filters only the active (not completed yet) tasks.
    ACTIVE_TASKS,

    // Filters only the completed tasks.
    COMPLETED_TASKS
}