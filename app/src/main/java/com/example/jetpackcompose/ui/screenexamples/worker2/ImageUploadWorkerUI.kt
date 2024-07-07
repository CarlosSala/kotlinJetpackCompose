package com.example.jetpackcompose.ui.screenexamples.worker2

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import coil.compose.rememberAsyncImagePainter
import java.util.concurrent.TimeUnit

@Composable
fun ImageUploadWorkerUI() {

    val viewModel: ImageUploadWorkerViewModel = viewModel()

    val context = LocalContext.current
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    // En tu actividad principal o fragmento
    val constraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.UNMETERED)
        .setRequiresBatteryNotLow(true)
        .build()

    val uploadWorkRequest = PeriodicWorkRequestBuilder<ImageUploadWorker>(1, TimeUnit.DAYS)
        .setConstraints(constraints)
        .build()

    WorkManager.getInstance(context).enqueueUniquePeriodicWork(
        "FileUploadWork",
        ExistingPeriodicWorkPolicy.KEEP,
        uploadWorkRequest
    )

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            imageUri = uri
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = {
            launcher.launch("image/*")
        }) {
            Text(text = "Select Image")
        }

        Spacer(modifier = Modifier.height(16.dp))

        imageUri?.let {
            ImagePreview(uri = it)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                viewModel.uploadImage(it)
            }) {
                Text(text = "Upload Image")
            }
        }
    }
}

@Composable
fun ImagePreview(uri: Uri) {
    Image(
        painter = rememberAsyncImagePainter(model = uri),
        contentDescription = null,
        modifier = Modifier
            .size(200.dp)
            .padding(16.dp)
    )
}
