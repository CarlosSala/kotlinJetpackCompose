package dev.leonardom.loginjetpackcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.jetpackcompose.ui.screenexamples.login.theme.Typography

private val DarkColorPalette = darkColors(
    primary =   BLUE900,
    primaryVariant = BLUE950,
    secondary = CYAN900,
    secondaryVariant = CYAN800,
    background = BLUEGREY900,
    surface = BLUEGREY800,
    error = RED800,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.White
)

private val LightColorPalette = lightColors(
    primary =   Blue500,
    primaryVariant = BLUE800,
    secondary = CYAN500,
    secondaryVariant = CYAN700,
    background = LIGHTBLUE50,
    surface = Color.White,
    error = RED600,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.Black
)

@Composable
fun LoginJetpackComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}