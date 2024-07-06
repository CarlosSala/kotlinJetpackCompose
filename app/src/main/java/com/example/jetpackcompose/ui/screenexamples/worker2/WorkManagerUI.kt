package com.example.jetpackcompose.ui.screenexamples.worker2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun WorkManagerUI() {

    val viewModel: WorkManagerViewModel = viewModel()

    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = { viewModel.startWorker() }, modifier = Modifier.padding(8.dp)) {
            Text(text = "Start Worker")
        }
        Button(onClick = { viewModel.stopWorker() }, modifier = Modifier.padding(8.dp)) {
            Text(text = "Stop Worker")
        }
    }
}
