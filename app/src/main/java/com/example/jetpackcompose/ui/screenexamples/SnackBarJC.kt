package com.example.jetpackcompose.ui.screenexamples

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch


@Preview(showBackground = true)
@Composable
fun SnackBarJC() {
    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
    ) { contentPadding ->

        // Screen content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    scope.launch {
                        val result = snackBarHostState.showSnackbar(
                            message = "Couldn't send photo",
                            actionLabel = "Retry",
                            withDismissAction = true,
                            duration = SnackbarDuration.Long
                        )
                        when (result) {
                            SnackbarResult.Dismissed -> {

                            }

                            SnackbarResult.ActionPerformed -> {
                                /* viewModel.sendPhoto*/
                            }
                        }
                    }
                }
            ) {
                Text(text = "Show SnackBar")
            }
        }
    }
}

@Preview
@Composable
fun SnackBarPreview() {

    SnackBarJC()
}