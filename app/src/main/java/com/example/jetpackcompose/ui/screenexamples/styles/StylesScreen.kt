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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.jetpackcompose.ui.theme.CustomComposeTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StylesScreen() {

    // var isDarkTheme by remember { mutableStateOf(false) }
    var selectedTheme by remember { mutableStateOf<ColorScheme>(lightColorScheme()) }
    // type scroll or scroll behavior
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    MyTheme(selectedTheme) {

        var showDialog by remember { mutableStateOf(false) }

        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                MediumTopAppBarExample(scrollBehavior)
            },
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
                                        items(MyThemes().listColorSchemes.entries.toList()) { theme ->
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
fun ThemeItem(
    colorScheme: Map.Entry<String, ColorScheme>,
    selectedTheme: (ColorScheme) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { selectedTheme(colorScheme.value) },
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Text(
            text = colorScheme.key,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun MyTheme(
    customColorScheme: ColorScheme,
    content: @Composable () -> Unit
) {
//     val colors = if (isDarkTheme) DarkThemeColors else LightThemeColors

    MaterialTheme(
        colorScheme = customColorScheme,
        typography = typography,
        shapes = shapes,
        content = content
    )
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
fun MediumTopAppBarExample(scrollBehavior: TopAppBarScrollBehavior) {

    MediumTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(
                "Medium Top App Bar",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Localized description"
                )
            }
        },
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Localized description"
                )
            }
        },
        scrollBehavior = scrollBehavior
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
