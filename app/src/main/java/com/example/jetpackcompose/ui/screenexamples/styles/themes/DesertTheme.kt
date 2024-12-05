package com.example.jetpackcompose.ui.screenexamples.styles.themes

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val DesertColors = lightColorScheme(
    primary = Color(0xFFFF6F00),
    secondary = Color(0xFF8D6E63),
    background = Color(0xFFFFF3E0),
    surface = Color(0xFFEFEBE9),
    onPrimary = Color.White,           // Texto en componentes primarios
    onSecondary = Color.White,         // Texto en componentes secundarios
    onBackground = Color.Black,        // Texto en el fondo
    onSurface = Color.Black            // Texto en superficies
)

private val DesertTypography = Typography(
    displayLarge = TextStyle(
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF5D4037)
    ),
    bodyMedium = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal
    ),
    labelLarge = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )
)

private val DesertShapes = Shapes(
    small = RoundedCornerShape(2.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(8.dp)
)

@Composable
fun DesertTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DesertColors,
        typography = DesertTypography,
        shapes = DesertShapes,
        content = content
    )
}
