package com.example.jetpackcompose.ui.screenexamples.roomnote2

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.TaskRepository
import com.example.jetpackcompose.ui.screenexamples.roomnote2.ui.tasksScreen.TasksScreen
import kotlinx.coroutines.CoroutineScope

@Composable
fun TaskAppNav(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    startDestination: String = AppScreens.TasksScreenRoute.route
) {
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: startDestination

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(
            route = AppScreens.TasksScreenRoute.route
        ) {
            AppModalDrawer(
                drawerState,
                currentRoute,
                navController,
                content = {
                    TasksScreen(openDrawer = {  })
                }
            )
        }
        composable(
            route = AppScreens.StatisticsScreenRoute.route
        ) {

        }

    }

}