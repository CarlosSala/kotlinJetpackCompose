package com.example.jetpackcompose.ui.screenexamples.roomnote2

import kotlinx.serialization.Serializable

/*
@Serializable
object TasksScreenRoute

@Serializable
object StatisticsScreenRoute*/

sealed class AppScreens(val route: String) {

    data object TasksScreenRoute : AppScreens("task_screen_route")
    data object StatisticsScreenRoute : AppScreens("statistics_screen_route")
}

object TaskDestinationsArgs {
    const val USER_MESSAGE_ARG = "userMessage"
    const val TASK_ID_ARG = "taskId"
    const val TITLE_ARG = "title"
}
