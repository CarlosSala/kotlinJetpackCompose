package com.example.jetpackcompose.ui.screens.ma9

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen() {
    Scaffold(
        topBar = { MainAppBar() }
    ) { paddingValues ->

        MediaList4(modifier = Modifier.padding(paddingValues))
    }
}