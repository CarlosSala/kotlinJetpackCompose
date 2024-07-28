package com.example.jetpackcompose.ui.screenexamples.worker3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcompose.ui.screenexamples.worker3.OneTimeWorkRequest.Companion.KEY_WORKER
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun OneTimeWorkRequestUI() {

    val viewModel: OneTimeWorkViewModel = viewModel()
    val coroutineScope = rememberCoroutineScope()
    val uploadState by viewModel.uploadState.collectAsState()
    val state by viewModel.state.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(
                space = 16.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(2.dp)
        ) {
            TextButton(
                onClick = {
                    coroutineScope.launch {
                        viewModel.uploadRequest()
                    }
                },
                modifier = Modifier.background(Color.Blue)
            ) {
                Text(
                    text = "Start",
                    modifier = Modifier,
                    color = Color.White
                )
            }
            Text(
                text = "Status: ${uploadState.name}",
                modifier = Modifier,
                color = Color.Black
            )
            Text(
                text = "Date: ${state?.getString(KEY_WORKER)}",
                modifier = Modifier,
                color = Color.Black
            )
        }
    }

}

@Preview
@Composable
fun MyPreview() {
    OneTimeWorkRequestUI()
}