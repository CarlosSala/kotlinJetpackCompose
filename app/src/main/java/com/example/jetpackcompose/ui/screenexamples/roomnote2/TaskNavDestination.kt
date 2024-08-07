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