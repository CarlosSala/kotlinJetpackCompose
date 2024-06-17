package com.example.jetpackcompose.ui.screens.cat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcompose.ui.screens.cat.detail.CatDetail
import com.example.jetpackcompose.ui.screens.pager.MyApp

class CatActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /* val navController = rememberNavController()

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
             }*/
            MyApp()
        }
    }
}
