package com.example.jetpackcompose.ui.screenexamples.worker2

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageUploadWorkerUI() {

    val context = LocalContext.current

    setupWorkManager(context)

    val viewModel: ImageUploadWorkerViewModel = viewModel()
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val uploadState by viewModel.uploadState.collectAsState()

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            imageUri = uri
        }
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Image Upload Worker") }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(onClick = { launcher.launch("image/*") }) {
                    Text(text = "Select Image")
                }

                Spacer(modifier = Modifier.height(16.dp))

                imageUri?.let {
                    ImagePreview(uri = it)
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { viewModel.uploadImage(it) },
                        enabled = uploadState != UploadState.Uploading
                    ) {
                        Text(text = if (uploadState == UploadState.Uploading) "Uploading..." else "Upload Image")
                    }
                }

                when (uploadState) {
                    UploadState.Success -> Text("Upload successful!", color = Color.Green)
                    UploadState.Error -> Text("Upload failed. Please try again.", color = Color.Red)
                    else -> Unit
                }
            }
        }
    )
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

// Enum to represent the upload state
enum class UploadState {
    Idle, Uploading, Success, Error
}

// Function to set up the WorkManager
fun setupWorkManager(context: Context) {
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
}

/*
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
*/