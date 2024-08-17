package com.example.jetpackcompose.ui.screenexamples.login.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Destinations(
    val route: String,
    val arguments: List<NamedNavArgument>
){

    data object Login: Destinations("login", emptyList())
    data object Register: Destinations("register", emptyList())
    data object Home: Destinations(
        "home",
        listOf(
            navArgument("email"){ type = NavType.StringType },
            navArgument("password"){ type = NavType.StringType }
        )
    )

}
