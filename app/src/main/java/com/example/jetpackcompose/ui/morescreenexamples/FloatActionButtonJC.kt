package com.example.jetpackcompose.ui.morescreenexamples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FABWithScaffold() {

    val listState = rememberLazyListState()
    val isExpanded by remember { derivedStateOf { listState.firstVisibleItemIndex == 0 } }

    Scaffold(
        floatingActionButton = {
            ExtendedFloatActionButton(expanded = isExpanded)
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { padding ->
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(50) {
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

@Preview
@Composable
fun FABPreview(modifier: Modifier = Modifier) {
    Column {
        NormalFloatActionButton()
        SmallFloatActionButton()
        LargeFloatActionButton()
        ExtendedFloatActionButton(expanded = true)
    }
}

@Composable
fun NormalFloatActionButton() {
    FloatingActionButton(onClick = { /* do something*/ }) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = null)
    }
}

@Composable
fun SmallFloatActionButton() {
    SmallFloatingActionButton(onClick = { /* do something*/ }) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = null)
    }
}

@Composable
fun LargeFloatActionButton() {
    LargeFloatingActionButton(onClick = { /* do something*/ }) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
            modifier = Modifier.size(FloatingActionButtonDefaults.LargeIconSize)
        )
    }
}

@Composable
fun ExtendedFloatActionButton(expanded: Boolean) {
    ExtendedFloatingActionButton(
        onClick = { /* do something*/ },
        icon = { Icon(imageVector = Icons.Filled.Add, contentDescription = null) },
        text = { Text(text = "Compose") },
        expanded = expanded
    )
}