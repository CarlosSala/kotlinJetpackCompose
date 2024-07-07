package com.example.jetpackcompose.ui.screenexamples.firebasestorage

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Preview(
    showBackground = true,
    name = "FirebaseStorageScreen",
    widthDp = 250,
    heightDp = 250
)
@Composable
fun FirebaseStorageScreen() {

    val firebaseStorageViewModel: FirebaseStorageViewModel = viewModel()

    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedImageUri = uri
    }

    val uploadProgress by firebaseStorageViewModel.uploadProgress.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { launcher.launch("image/*") }) {
            Text("Select Image")
        }

        Spacer(modifier = Modifier.height(16.dp))

        selectedImageUri?.let { uri ->
            ImagePreview(uri = uri)

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                firebaseStorageViewModel.uploadImage(
                    uri,
                    onSuccess = { /* Handle success */ },
                    onError = { /* Handle error */ }
                )
            }) {
                Text("Upload Image")
            }

            Spacer(Modifier.height(16.dp))

            if (uploadProgress > 0f && uploadProgress < 100f) {
                Text("Upload Progress: ${uploadProgress.toInt()}%")
                LinearProgressIndicator(
                    progress = { uploadProgress / 100 },
                )
            }
        }
    }
}

@Composable
fun ImagePreview(uri: Uri) {
    Image(
        painter = rememberAsyncImagePainter(uri),
        contentDescription = null,
        modifier = Modifier
            .size(200.dp)
            .clip(RoundedCornerShape(16.dp))
    )
}