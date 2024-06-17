package com.example.jetpackcompose.ui.screens.pager

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Pantalla1() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Pantalla 1", color = Color.Black)
    }
}

@Composable
fun Pantalla2() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Pantalla 2", color = Color.Black)
    }
}

@Composable
fun Pantalla3() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Pantalla 3", color = Color.Black)
    }
}

@Preview(
    showBackground = true,
    name = "Testing My first app with JC",
    widthDp = 250,
    heightDp = 250
)
@Composable
fun DefaultPreview1() {
    Pantalla1()
}
