package com.example.jetpackcompose.ui.morescreenexamples

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun BottomAppBarWithScaffoldJC() {
    Scaffold(
        bottomBar = { BottomAppBarJC() }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(30) {
                ListItem(
                    headlineContent = { Text(text = "Item $it") },
                    leadingContent = {
                        Icon(imageVector = Icons.Default.Face, contentDescription = null)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomAppBarJC() {
    BottomAppBar(
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(Icons.Filled.Check, contentDescription = null)
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(Icons.Filled.Edit, contentDescription = null)
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(Icons.Filled.Search, contentDescription = null)
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(Icons.Filled.Share, contentDescription = null)
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* do something */ },
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor
            ) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
        }
    )
}