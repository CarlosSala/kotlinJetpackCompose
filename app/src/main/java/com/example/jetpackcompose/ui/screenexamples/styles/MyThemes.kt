package com.example.jetpackcompose.ui.screenexamples.styles

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

class MyThemes {

    private val lightThemeColors: ColorScheme = lightColorScheme(
        primary = Color.Red,
        background = Color.Yellow,
        surface = Color(0xFFFFFBFE),
        onPrimary = Color.White,
        onSecondary = Color.White,
        onTertiary = Color.White,
        onBackground = Color(0xFF1C1B1F),
        onSurface = Color(0xFF1C1B1F),
    )

    private val darkThemeColors = darkColorScheme(
        primary = Color(0xFF00BCD4), // Cian más oscuro
        primaryContainer = Color(0xFF00838F), // Contenedor primario
        secondary = Color(0xFFCDDC39), // Lima para el secundario
        secondaryContainer = Color(0xFF8BC34A), // Contenedor secundario
        background = Color(0xFF303030), // Gris oscuro para fondo
        surface = Color(0xFF424242), // Gris oscuro para superficie
        onPrimary = Color.Black,
        onSecondary = Color.Black,
        onTertiary = Color.Black,
        onBackground = Color(0xFFE0E0E0), // Gris claro para mejor lectura
        onSurface = Color(0xFFE0E0E0), // Gris claro para mejor lectura
    )


    private val blueThemeColors = lightColorScheme(
        primary = Color(0xFF2196F3), // Azul primario
        primaryContainer = Color(0xFFBBDEFB), // Contenedor primario azul claro
        secondary = Color(0xFFFFC107), // Ámbar para secundario
        secondaryContainer = Color(0xFFFFE082), // Contenedor secundario ámbar claro
        background = Color(0xFFE3F2FD), // Fondo azul muy claro
        surface = Color(0xFFFFFFFF), // Blanco para superficie
        onPrimary = Color.White,
        onSecondary = Color.Black,
        onTertiary = Color.Black,
        onBackground = Color(0xFF0D47A1), // Azul muy oscuro para texto
        onSurface = Color(0xFF0D47A1), // Azul muy oscuro para texto
    )

    private val greenThemeColors = lightColorScheme(
        primary = Color(0xFF4CAF50), // Verde primario
        primaryContainer = Color(0xFFC8E6C9), // Contenedor primario verde claro
        secondary = Color(0xFFFF9800), // Naranja para secundario
        secondaryContainer = Color(0xFFFFCC80), // Contenedor secundario naranja claro
        background = Color(0xFFF1F8E9), // Fondo verde muy claro
        surface = Color(0xFFFFFFFF), // Blanco para superficie
        onPrimary = Color.White,
        onSecondary = Color.Black,
        onTertiary = Color.Black,
        onBackground = Color(0xFF2E7D32), // Verde muy oscuro para texto
        onSurface = Color(0xFF2E7D32), // Verde muy oscuro para texto
    )

    private val purpleThemeColors = lightColorScheme(
        primary = Color(0xFF9C27B0), // Púrpura primario
        primaryContainer = Color(0xFFE1BEE7), // Contenedor primario púrpura claro
        secondary = Color(0xFFFF5722), // Naranja para secundario
        secondaryContainer = Color(0xFFFFAB91), // Contenedor secundario naranja claro
        background = Color(0xFFF3E5F5), // Fondo púrpura muy claro
        surface = Color(0xFFFFFFFF), // Blanco para superficie
        onPrimary = Color.White,
        onSecondary = Color.Black,
        onTertiary = Color.Black,
        onBackground = Color(0xFF4A148C), // Púrpura muy oscuro para texto
        onSurface = Color(0xFF4A148C), // Púrpura muy oscuro para texto
    )

    private val orangeThemeColors = lightColorScheme(
        primary = Color(0xFFFF9800), // Naranja primario
        primaryContainer = Color(0xFFFFE0B2), // Contenedor primario naranja claro
        secondary = Color(0xFF607D8B), // Gris azul para secundario
        secondaryContainer = Color(0xFFCFD8DC), // Contenedor secundario gris azul claro
        background = Color(0xFFFFF3E0), // Fondo naranja muy claro
        surface = Color(0xFFFFFFFF), // Blanco para superficie
        onPrimary = Color.Black,
        onSecondary = Color.White,
        onTertiary = Color.White,
        onBackground = Color(0xFFE65100), // Naranja muy oscuro para texto
        onSurface = Color(0xFFE65100), // Naranja muy oscuro para texto
    )
    private val tealThemeColors = lightColorScheme(
        primary = Color(0xFF009688), // Turquesa primario
        primaryContainer = Color(0xFFB2DFDB), // Contenedor primario turquesa claro
        secondary = Color(0xFFCDDC39), // Lima para secundario
        secondaryContainer = Color(0xFFF0F4C3), // Contenedor secundario lima claro
        background = Color(0xFFE0F2F1), // Fondo turquesa muy claro
        surface = Color(0xFFFFFFFF), // Blanco para superficie
        onPrimary = Color.White,
        onSecondary = Color.Black,
        onTertiary = Color.Black,
        onBackground = Color(0xFF004D40), // Turquesa muy oscuro para texto
        onSurface = Color(0xFF004D40), // Turquesa muy oscuro para texto
    )

    val listColorSchemes = mapOf(
        "Light Theme" to lightThemeColors,
        "Dark Theme" to darkThemeColors,
        "Blue Theme" to blueThemeColors,
        "Green Theme" to greenThemeColors,
        "Purple Theme" to purpleThemeColors,
        "Orange Theme" to orangeThemeColors,
        "Teal Theme" to tealThemeColors
    )
}