@file:OptIn(ExperimentalMaterial3Api::class)

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcompose.ui.screenexamples.service2.DownloadService

@Composable
fun DownloadScreen(viewModel: DownloadViewModel = viewModel()) {

    val context = LocalContext.current

    val progress by viewModel.progress.collectAsState()
    val hasNotificationPermission by viewModel.hasNotificationPermission.collectAsState()

    // Solicitar permiso si es necesario
    LaunchedEffect(Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val isGranted = ContextCompat.checkSelfPermission(
                context, Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
            viewModel.updateNotificationPermission(isGranted)
        } else {
            viewModel.updateNotificationPermission(true)
        }
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Download Service") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Progreso: $progress%", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))
            LinearProgressIndicator(progress = { progress / 100f })
            Spacer(modifier = Modifier.height(16.dp))

            if (hasNotificationPermission) {
                Button(onClick = { startDownloadService(context) }) {
                    Text("Iniciar Descarga")
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { stopDownloadService(context) }) {
                    Text("Detener Descarga")
                }
            } else {
                Text(
                    text = "El permiso de notificaciones es requerido para iniciar la descarga.",
                    color = MaterialTheme.colorScheme.error
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { requestNotificationPermission(context, viewModel) }) {
                    Text("Solicitar Permiso")
                }
            }
        }
    }
}

private fun startDownloadService(context: Context) {
    Log.d("DownloadScreen", "Iniciando el servicio...")
    val serviceIntent = Intent(context, DownloadService::class.java)
    ContextCompat.startForegroundService(context, serviceIntent)
}

private fun stopDownloadService(context: Context) {
    Log.d("DownloadScreen", "Deteniendo el servicio...")
    val serviceIntent = Intent(context, DownloadService::class.java)
    context.stopService(serviceIntent)
}

private fun requestNotificationPermission(context: Context, viewModel: DownloadViewModel) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        val launcher = (context as? androidx.activity.ComponentActivity)?.activityResultRegistry
        val requestPermissionLauncher = launcher?.register(
            "POST_NOTIFICATIONS",
            androidx.activity.result.contract.ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            viewModel.updateNotificationPermission(isGranted)
        }
        requestPermissionLauncher?.launch(Manifest.permission.POST_NOTIFICATIONS)
    }
}
