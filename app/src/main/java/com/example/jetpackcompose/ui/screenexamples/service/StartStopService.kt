package com.example.jetpackcompose.ui.screenexamples.service

import android.content.Context
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun StartStopServiceButton() {

    val context: Context = LocalContext.current

    val viewModel: MyBackgroundServiceViewModel = viewModel()

    var isServiceRunning by remember { mutableStateOf(false) }

    Button(
        onClick = {
            isServiceRunning = !isServiceRunning

            if (isServiceRunning) {
                viewModel.startMyBackgroundService(context)
            } else {
                viewModel.stopMyBackgroundService(context)
            }
        }
    ) {
        Text(if (isServiceRunning) "Detener Servicio" else "Iniciar Servicio")
    }
}