package com.example.jetpackcompose.ui.screenexamples.login.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = BLUE900,
    onPrimary = Color.White,
    primaryContainer = BLUE950,
    onPrimaryContainer = Color.White,
    secondary = CYAN900,
    onSecondary = Color.White,
    secondaryContainer = CYAN800,
    onSecondaryContainer = Color.White,
    background = BLUEGREY900,
    onBackground = Color.White,
    surface = BLUEGREY800,
    onSurface = Color.White,
    error = RED800,
    onError = Color.White,
)

private val LightColorScheme = lightColorScheme(
    primary = Blue500,
    onPrimary = Color.Black,
    primaryContainer = BLUE800,
    onPrimaryContainer = Color.Black,
    secondary = CYAN500,
    onSecondary = Color.Black,
    secondaryContainer = CYAN700,
    onSecondaryContainer = Color.Black,
    background = LIGHTBLUE50,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    error = RED600,
    onError = Color.Black,
)


@Composable
fun LoginJetpackComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colors,
        typography = montserratTypography,
        shapes = Shapes,
        content = content
    )
}