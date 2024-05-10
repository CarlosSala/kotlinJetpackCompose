package com.example.jetpackcompose.ui.screens.ma9

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.jetpackcompose.ui.screens.MyApp

@Composable
fun MainScreen(navController: NavHostController) {
    MyApp {
        Scaffold(
            topBar = { MainAppBar() }
        ) { paddingValues ->

            MediaList4(navController, modifier = Modifier.padding(paddingValues))
        }
    }
}