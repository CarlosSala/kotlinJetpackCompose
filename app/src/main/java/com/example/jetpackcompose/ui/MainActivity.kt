package com.example.jetpackcompose.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import androidx.lifecycle.Observer
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.common.SplashNavigation
import com.example.jetpackcompose.ui.screenexamples.paging.presentation.PagingScreen
import com.google.firebase.FirebaseApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.Theme_JetpackCompose)
        super.onCreate(savedInstanceState)
        // UI will use all screen
        enableEdgeToEdge()
        setContent {

            FirebaseApp.initializeApp(this)
            SplashNavigation()
            // PagingScreen()
            // HorizontalPager()
            // MyApp()

            // Observe the WorkManager Task Status
            observeWorkManager()
        }
    }

    private fun observeWorkManager() {
        WorkManager.getInstance(this).getWorkInfosForUniqueWorkLiveData("QuoteUpdateWorker")
            .observe(this, Observer { workInfos ->
                workInfos?.forEach { workInfo ->
                    Log.d("QuoteUpdateWorker", "Estado del trabajo: ${workInfo.state}")
                    if (workInfo.state == WorkInfo.State.FAILED) {
                        Log.d("QuoteUpdateWorker", "Error al actualizar el widget.")
                    }
                }
            })
    }
}