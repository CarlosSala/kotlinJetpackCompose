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
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.jetpackcompose.ui.theme.CustomComposeTheme


@Composable
fun StylesScreen() {
    CustomComposeTheme(
        darkTheme = true,
        dynamicColor = true
    ) {
        var showDialog by remember { mutableStateOf(false) }

        Scaffold(
            topBar = { TopBar() },
            floatingActionButton = {
                FloatAB(showDialog) {
                    showDialog = it
                }
            },
            bottomBar = { BottomNavigationBar() },
            content = { it ->
                Content(it)

                if (showDialog) {

                    Dialog(
                        onDismissRequest = {
                            showDialog = false
                        }
                    ) {
                        Surface(
                            modifier = Modifier.fillMaxHeight(0.75f),
                            shape = MaterialTheme.shapes.medium,
                            color = MaterialTheme.colorScheme.background,
                        ) {
                            Column {
                                Text(
                                    text = "Select an option:",
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier.padding(16.dp)
                                )
                                Box(
                                    modifier = Modifier.fillMaxHeight()
                                ) {
                                    LazyColumn(
                                        modifier = Modifier.padding(16.dp)
                                    )
                                    {
                                        items(AppTheme.entries) { theme ->
                                            ItemTheme(theme) { dismissDialog ->
                                                showDialog = dismissDialog
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
fun ItemTheme(theme: AppTheme, content: (Boolean) -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { content(false) },
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Text(
            text = theme.name,
            modifier = Modifier.padding(16.dp)

        )
    }
}

enum class AppTheme {
    LIGHT,
    DARK,
    USER_DEFINED,
    SYSTEM_DEFAULT,
    HIGH_CONTRAST,
    CUSTOM_THEME1,
    CUSTOM_THEME2
}


@Composable
fun FloatAB(showDialog: Boolean, onShowDialog: (Boolean) -> Unit) {

    FloatingActionButton(
        onClick = {
            if (showDialog) onShowDialog(false) else onShowDialog(true)
        }
    ) {
        Text("Theme")
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
