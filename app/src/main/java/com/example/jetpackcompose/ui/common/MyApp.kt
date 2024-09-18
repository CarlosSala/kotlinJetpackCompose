package com.example.jetpackcompose.ui.common

import androidx.compose.runtime.Composable
import com.example.jetpackcompose.ui.theme.CustomComposeTheme

@Composable
 fun MyApp(content: @Composable () -> Unit) {

    CustomComposeTheme {
        content()
    }
}