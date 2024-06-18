package com.example.jetpackcompose.ui.screenExamples.cat

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcompose.ui.screenExamples.cat.detail.CatDetail


@Composable
fun NavigationCat() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main") {
            MainScreen(navController)
        }
        composable(
            // optional argument
            // route = "detail?mediaId={mediaId}",
            route = "detail/{mediaId}",
            arguments = listOf(
                navArgument("mediaId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("mediaId")
            requireNotNull(id)
            CatDetail(id)
        }
    }
}