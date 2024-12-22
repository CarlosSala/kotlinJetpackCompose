package com.example.jetpackcompose.ui.screenexamples.service2

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DownloadScreen(viewModel: DownloadViewModel = viewModel()) {

    val context = LocalContext.current
    val progress by viewModel.progress.collectAsState()
    val hasNotificationPermission by viewModel.hasNotificationPermission.collectAsState()

    // when the permission already has been granted, the viewmodel will be notified
    LaunchedEffect(Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val isGranted = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
            viewModel.updateNotificationPermission(isGranted)
        } else {
            viewModel.updateNotificationPermission(true)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Download Service") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Progress: $progress%",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(16.dp))
            LinearProgressIndicator(progress = { progress / 100f })
            Spacer(modifier = Modifier.height(16.dp))

            if (hasNotificationPermission) {
                Button(onClick = { startDownloadService(context) }) {
                    Text("Start download")
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { stopDownloadService(context) }) {
                    Text("Stop download")
                }
            } else {
                Text(
                    text = "Notification permission is required to start the download service",
                    color = MaterialTheme.colorScheme.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { requestNotificationPermission(context, viewModel) }) {
                    Text("Request permission")
                }
            }
        }
    }
}

// this method is only available in Android 12 or higher,
// this is the message that will be shown to the user when the permission is requested
private fun requestNotificationPermission(context: Context, viewModel: DownloadViewModel) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        val launcher = (context as? ComponentActivity)?.activityResultRegistry
        val requestPermissionLauncher = launcher?.register(
            "POST_NOTIFICATIONS",
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            viewModel.updateNotificationPermission(isGranted)
        }
        requestPermissionLauncher?.launch(Manifest.permission.POST_NOTIFICATIONS)
    }
}

private fun startDownloadService(context: Context) {
    Log.d("DownloadScreen", "Starting service...")
    val serviceIntent = Intent(context, DownloadService::class.java)
    ContextCompat.startForegroundService(context, serviceIntent)
}

private fun stopDownloadService(context: Context) {
    Log.d("DownloadScreen", "Stopping service")
    val serviceIntent = Intent(context, DownloadService::class.java)
    context.stopService(serviceIntent)
}

