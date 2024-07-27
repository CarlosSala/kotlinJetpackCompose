package com.example.jetpackcompose.ui.screenexamples.worker3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.screenexamples.changeBackground
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun OneTimeWorkRequestUI() {

    val viewModel: OneTimeWorkViewModel = viewModel()

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
                onClick = { viewModel.uploadRequest() },
                modifier = Modifier.background(Color.Blue)
            ) {
                Text(
                    text = "Start",
                    modifier = Modifier,
                    color = Color.White
                )
            }
            Text(
                text = "Status",
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