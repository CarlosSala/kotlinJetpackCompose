package com.example.jetpackcompose.ui.screenexamples.worker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyPeriodicWorkerUI() {

    val viewModel: MyPeriodicWorkerViewModel = viewModel()
    val isWorkerRunning by viewModel.isWorkerRunning.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Periodic Worker") }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = if (isWorkerRunning) "Worker is Running" else "Worker is Stopped",
                    style = MaterialTheme.typography.bodyLarge,
                    color = if (isWorkerRunning) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
                Button(
                    onClick = { viewModel.startWorker() },
                    enabled = !isWorkerRunning,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(text = "Start Worker")
                }
                Button(
                    onClick = { viewModel.stopWorker() },
                    enabled = isWorkerRunning,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(text = "Stop Worker")
                }
            }
        }
    )
}
