package com.example.jetpackcompose.ui.screenexamples.service

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.*
import androidx.compose.runtime.*
import kotlinx.coroutines.launch

@Composable
fun MyServiceScreen() {

    val context = LocalContext.current

    val viewModel: MyServiceViewModel = viewModel()

    var isServiceRunning by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    val buttonText = if (isServiceRunning) "Detener Servicio" else "Iniciar Servicio"
    val snackbarText = if (isServiceRunning) "Servicio detenido" else "Servicio iniciado"

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Estado del Servicio: ${if (isServiceRunning) "Corriendo" else "Detenido"}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Button(
                onClick = {
                    isServiceRunning = !isServiceRunning

                    if (isServiceRunning) {
                        viewModel.startMyBackgroundService(context)
                    } else {
                        viewModel.stopMyBackgroundService(context)
                    }

                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(snackbarText)
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isServiceRunning) Color.Red else Color.Green,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(buttonText)
            }
        }
    }
}


/*
@Composable
fun MyServiceScreen() {

    val context: Context = LocalContext.current

    val viewModel: MyServiceViewModel = viewModel()

    var isServiceRunning by remember { mutableStateOf(false) }
    val scaffoldState = rememberScaffoldState()

    val buttonText = if (isServiceRunning) "Detener Servicio" else "Iniciar Servicio"
    val snackbarText = if (isServiceRunning) "Servicio detenido" else "Servicio iniciado"

    Scaffold(
        scaffoldState = scaffoldState
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Estado del Servicio: ${if (isServiceRunning) "Corriendo" else "Detenido"}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Button(
                onClick = {
                    isServiceRunning = !isServiceRunning

                    if (isServiceRunning) {
                        viewModel.startMyBackgroundService(context)
                    } else {
                        viewModel.stopMyBackgroundService(context)
                    }

                    LaunchedEffect(isServiceRunning) {
                        scaffoldState.snackbarHostState.showSnackbar(snackbarText)
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (isServiceRunning) Color.Red else Color.Green,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(buttonText)
            }
        }
    }
}
*/


/*
@Composable
fun MyServiceScreen() {

    val context: Context = LocalContext.current

    val viewModel: MyServiceViewModel = viewModel()

    var isServiceRunning by remember { mutableStateOf(false) }
    var showSnackbar by remember { mutableStateOf(false) }

    val buttonText = if (isServiceRunning) "Detener Servicio" else "Iniciar Servicio"
    val snackbarText = if (isServiceRunning) "Servicio detenido" else "Servicio iniciado"

    Scaffold(
        scaffoldState = rememberScaffoldState()
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Estado del Servicio: ${if (isServiceRunning) "Corriendo" else "Detenido"}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Button(
                onClick = {
                    isServiceRunning = !isServiceRunning

                    if (isServiceRunning) {
                        viewModel.startMyBackgroundService(context)
                    } else {
                        viewModel.stopMyBackgroundService(context)
                    }
                    showSnackbar = true
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (isServiceRunning) Color.Red else Color.Green,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(buttonText)
            }

            if (showSnackbar) {
                Snackbar(
                    action = {
                        TextButton(onClick = { showSnackbar = false }) {
                            Text("OK")
                        }
                    },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(snackbarText)
                }
            }
        }
    }
}
*/


/*
@Composable
fun MyServiceScreen() {

    val context: Context = LocalContext.current

    val viewModel: MyServiceViewModel = viewModel()

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
}*/
