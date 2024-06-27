package com.example.jetpackcompose.ui.screenExamples.tabrowscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Screen2(modifier: Modifier = Modifier) {
    Surface(modifier = modifier.fillMaxSize(), color = Color.Magenta) {

        Greeting2(name = "Screen 2")

    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello from the $name!",
        modifier = modifier
    )
}