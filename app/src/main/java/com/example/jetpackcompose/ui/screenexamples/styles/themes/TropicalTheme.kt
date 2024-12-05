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

private val TropicalColors = lightColorScheme(
    primary = Color(0xFF00BFA5),
    secondary = Color(0xFFFFC107),
    background = Color(0xFFE8F5E9),
    surface = Color(0xFFFFFFFF),
    onPrimary = Color.White,           // Texto en componentes primarios
    onSecondary = Color.Black,         // Texto en componentes secundarios
    onBackground = Color.Black,        // Texto en el fondo
    onSurface = Color.Black            // Texto en superficies
)

private val TropicalTypography = Typography(
    displayLarge = TextStyle(
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF004D40)
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

private val TropicalShapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(24.dp)
)

@Composable
fun TropicalTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = TropicalColors,
        typography = TropicalTypography,
        shapes = TropicalShapes,
        content = content
    )
}
