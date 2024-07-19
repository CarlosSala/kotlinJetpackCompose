package com.example.jetpackcompose.ui.common

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.jetpackcompose.ui.HorizontalPager
import com.example.jetpackcompose.ui.screenexamples.paging.presentation.PagingScreen


@Composable
fun SplashNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SplashScreen
    ) {
        composable<SplashScreen> {
            SplashScreen(navController)
        }
        composable<MainScreen> {
            HorizontalPager()
            // PagingScreen()
        }
    }
}