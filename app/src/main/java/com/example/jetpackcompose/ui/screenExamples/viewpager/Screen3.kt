package com.example.jetpackcompose.ui.screenExamples.viewpager

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Screen3(modifier: Modifier = Modifier) {
    Surface(modifier = modifier.fillMaxSize(), color = Color.Cyan) {

        Greeting3(name = "Screen 3")

    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello from the $name!",
        modifier = modifier
    )
}