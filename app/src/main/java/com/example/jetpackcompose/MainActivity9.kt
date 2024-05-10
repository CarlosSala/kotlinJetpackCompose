package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetpackcompose.ui.screens.ma9.MainScreen
import com.example.jetpackcompose.ui.screens.MyApp

class MainActivity9 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainScreen()
            }
        }
    }
}