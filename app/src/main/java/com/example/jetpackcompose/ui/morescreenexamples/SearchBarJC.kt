package com.example.jetpackcompose.ui.morescreenexamples

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose.R

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarJC() {

    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    val searchHistory = listOf("Android", "Kotlin", "Compose", "Material Design", "GPT-4")

    SearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                query = query,
                onQueryChange = { query = it },
                onSearch = { newQuery -> println("Performing search on query: $newQuery") },
                expanded = active,
                onExpandedChange = { active = it },
                placeholder = { Text("Search") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search"
                    )
                },
                trailingIcon = {
                    if (active) {
                        IconButton(
                            onClick = { if (query.isNotEmpty()) query = "" else active = false }
                        ) {
                            Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
                        }
                    }
                },
                colors = SearchBarDefaults.inputFieldColors(),
                modifier = TODO(),
                enabled = TODO(),
                interactionSource = TODO()
            )
        },
        expanded = active,
        onExpandedChange = { active = it },
        modifier = Modifier,
        shape = TODO(),
        colors = TODO(),
        tonalElevation = TODO(),
        shadowElevation = TODO(),
        windowInsets = TODO(),
    ) {
        searchHistory.takeLast(3).forEach { item ->
            ListItem(
                modifier = Modifier.clickable { query = item },
                headlineContent = { Text(text = item) },
                leadingContent = {
                    Icon(
                        painter = painterResource(R.drawable.ic_list),
                        contentDescription = null
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DockedSearchBarJC() {
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    val searchHistory = listOf("Android", "Kotlin", "Compose", "Material Design", "GPT-4")

    DockedSearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                modifier = Modifier.fillMaxWidth(),
                query = query,
                onQueryChange = { query = it },
                onSearch = { newQuery ->
                    println("Performing search on query: $newQuery")
                },
                expanded = active,
                onExpandedChange = { active = it },
                enabled = true,
                placeholder = {
                    Text("Search")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
                },
                trailingIcon = {
                    Row {
                        IconButton(onClick = { /* open mic dialog */ }) {
                            // Icon(painter = painterResource(R.drawable.ic_mic), contentDescription = "Mic")
                        }
                        if (active) {
                            IconButton(
                                onClick = { if (query.isNotEmpty()) query = "" else active = false }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Close,
                                    contentDescription = "Close"
                                )
                            }
                        }
                    }
                },
                colors = SearchBarDefaults.colors().inputFieldColors,
                interactionSource = remember { MutableInteractionSource() }
            )
        },
        expanded = active,
        onExpandedChange = { active = it },
        modifier = Modifier.fillMaxWidth(),
        shape = SearchBarDefaults.dockedShape,
        colors = SearchBarDefaults.colors(),
        tonalElevation = SearchBarDefaults.TonalElevation,
        shadowElevation = SearchBarDefaults.ShadowElevation,
        content = {
            searchHistory.takeLast(3).forEach { item ->
                ListItem(
                    modifier = Modifier.clickable { query = item },
                    headlineContent = { Text(text = item) },
                    leadingContent = {
                        Icon(
                            painter = painterResource(R.drawable.ic_list),
                            contentDescription = null
                        )
                    }
                )
            }
        }
    )
}