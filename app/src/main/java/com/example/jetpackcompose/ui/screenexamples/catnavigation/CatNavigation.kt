package com.example.jetpackcompose.ui.screenexamples.catnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.jetpackcompose.ui.screenexamples.catnavigation.detail.CatDetail

@Composable
fun CatNavigation() {

    // for controller navigation status
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Main
    ) {
        composable<Main> {
            CatScreen { onCatClick ->
                navController.navigate(Detail(onCatClick.id))
            }
        }
        composable<Detail> { backStackEntry ->
            val detail = backStackEntry.toRoute<Detail>()
            CatDetail(
                mediaId = detail.mediaId,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}