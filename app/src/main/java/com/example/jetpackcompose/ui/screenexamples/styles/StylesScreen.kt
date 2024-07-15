package com.example.jetpackcompose.ui.screenexamples.styles

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.jetpackcompose.ui.theme.CustomComposeTheme


@Composable
fun StylesScreen() {
    /*    CustomComposeTheme(
            darkTheme = true,
            dynamicColor = true
        ) {*/

    // var isDarkTheme by remember { mutableStateOf(false) }
    var selectedTheme by remember { mutableStateOf(AppTheme.LIGHT_THEME) }

    MyTheme(selectedTheme) {

        var showDialog by remember { mutableStateOf(false) }

        Scaffold(
            topBar = { TopBar() },
            floatingActionButton = {
                FloatAB { open ->
                    showDialog = open
                }
            },
            bottomBar = { BottomNavigationBar() },
            content = { paddingValues ->
                Content(paddingValues)

                if (showDialog) {

                    Dialog(
                        onDismissRequest = {
                            showDialog = false
                        }
                    ) {
                        Surface(
                            modifier = Modifier.fillMaxHeight(0.5f),
                            shape = MaterialTheme.shapes.medium,
                            color = MaterialTheme.colorScheme.background,
                        ) {
                            Column {
                                Text(
                                    text = "Select a Theme:",
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier
                                        .padding(16.dp)
                                )
                                Box(
                                    modifier = Modifier.fillMaxHeight()
                                ) {
                                    LazyColumn(
                                        modifier = Modifier.padding(16.dp)
                                    )
                                    {
                                        items(AppTheme.entries) { theme ->
                                            ThemeItem(theme) { newTheme ->
                                                selectedTheme = newTheme
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun ThemeItem(theme: AppTheme, selectedTheme: (AppTheme) -> Unit) {
    /*    when (theme) {

            AppTheme.LIGHT -> {
                content(false)
            }

            AppTheme.DARK -> {
                content(true)
            }

            AppTheme.USER_DEFINED -> TODO()
            AppTheme.SYSTEM_DEFAULT -> TODO()
            AppTheme.HIGH_CONTRAST -> TODO()
            AppTheme.CUSTOM_THEME1 -> TODO()
            AppTheme.CUSTOM_THEME2 -> TODO()
        }*/
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { selectedTheme(theme) },
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Text(
            text = theme.name,
            modifier = Modifier.padding(16.dp)
        )
    }
}

private val LightThemeColors = lightColorScheme(
    primary = Color.Red,
    background = Color.Yellow,
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
)

private val DarkThemeColors = darkColorScheme(
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


private val BlueThemeColors = lightColorScheme(
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

private val GreenThemeColors = lightColorScheme(
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

private val PurpleThemeColors = lightColorScheme(
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

private val OrangeThemeColors = lightColorScheme(
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
private val TealThemeColors = lightColorScheme(
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


@Composable
fun MyTheme(
    themeSelected: AppTheme,
    content: @Composable () -> Unit
) {
//     val colors = if (isDarkTheme) DarkThemeColors else LightThemeColors
    val colors = when (themeSelected) {

        AppTheme.LIGHT_THEME -> LightThemeColors
        AppTheme.DARK_THEME -> DarkThemeColors
        AppTheme.BLUE_THEME -> BlueThemeColors
        AppTheme.GREEN_THEME -> GreenThemeColors
        AppTheme.PURPLE_THEME -> PurpleThemeColors
        AppTheme.ORANGE_THEME -> OrangeThemeColors
        AppTheme.TEAL_THEME -> TealThemeColors
    }

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}


enum class AppTheme {
    LIGHT_THEME,
    DARK_THEME,
    BLUE_THEME,
    GREEN_THEME,
    PURPLE_THEME,
    ORANGE_THEME,
    TEAL_THEME
}


@Composable
fun FloatAB(onShowDialog: (Boolean) -> Unit) {

    FloatingActionButton(
        onClick = {
            onShowDialog(true)
        }
    ) {
        Text("Open")
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text("My App") }
    )
}

@Composable
fun Content(paddingValues: PaddingValues) {

    val items = remember { List(20) { "Item $it" } }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            start = 16.dp,
            top = paddingValues.calculateTopPadding(),
            end = 16.dp,
            bottom = paddingValues.calculateBottomPadding()
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            ListItem(item)
        }
    }
}

@Composable
fun ListItem(item: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Text(
            text = item,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { Text("Home") },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Settings, contentDescription = null) },
            label = { Text("Settings") },
            selected = false,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CustomComposeTheme {
        StylesScreen()
    }
}
