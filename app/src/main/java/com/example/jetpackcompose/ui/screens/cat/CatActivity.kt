package com.example.jetpackcompose.ui.screens.cat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetpackcompose.ui.screens.horizontalPager.MyApp

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
