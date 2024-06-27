package com.example.jetpackcompose.ui.screenExamples.settings


import WelcomeDialog
import android.app.Application
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.ViewModelProvider

@Composable
fun SettingsScreen(
    viewModel: WelcomeViewModel = viewModel(
        factory = ViewModelProvider.AndroidViewModelFactory.getInstance(
            LocalContext.current.applicationContext as Application
        )
    )
) {
    val welcomeShown by viewModel.welcomeShown.collectAsState()

    if (!welcomeShown) {
        WelcomeDialog(onDismiss = {
            viewModel.setWelcomeShown()
        })
    }

    // El resto de tu UI
}


