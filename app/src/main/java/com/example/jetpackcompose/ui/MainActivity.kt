package com.example.jetpackcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.common.SplashNavigation
import com.google.firebase.FirebaseApp


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.Theme_JetpackCompose)

        super.onCreate(savedInstanceState)
        setContent {

            FirebaseApp.initializeApp(this)
            SplashNavigation()
            // HorizontalPager()
            // MyApp()
        }

    }
}