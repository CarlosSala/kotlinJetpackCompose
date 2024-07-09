package com.example.jetpackcompose.ui.screenexamples.welcomescreen


import WelcomeDialog
import android.app.Application
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen(
    viewModel: WelcomeViewModel = viewModel(
        factory = ViewModelProvider.AndroidViewModelFactory.getInstance(
            LocalContext.current.applicationContext as Application
        )
    )
) {
    val welcomeShown by viewModel.welcomeShown.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        if (!welcomeShown) {
            delay(1500) //
            showDialog = true
        }
    }


    if (showDialog) {
        WelcomeDialog(
            showDialog = showDialog,
            onDismiss = {
                showDialog = false
                viewModel.setWelcomeShown()
            }
        )
    }
}


