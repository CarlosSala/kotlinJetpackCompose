package com.example.jetpackcompose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose.ui.screenExamples.BoxJC
import com.example.jetpackcompose.ui.screenExamples.ButtonTextJC
import com.example.jetpackcompose.ui.screenExamples.ColumnJC
import com.example.jetpackcompose.ui.screenExamples.LazyColumnJC
import com.example.jetpackcompose.ui.screenExamples.LazyRowJC
import com.example.jetpackcompose.ui.screenExamples.LazyVerticalGridJC
import com.example.jetpackcompose.ui.screenExamples.NavDrawerJC
import com.example.jetpackcompose.ui.screenExamples.RowJC
import com.example.jetpackcompose.ui.screenExamples.cat.MainAppBar
import com.example.jetpackcompose.ui.screenExamples.cat.NavigationCat
import com.example.jetpackcompose.ui.screenExamples.counterScreen.IncrementNumber
import com.example.jetpackcompose.ui.screenExamples.mutablestate.ViewMutableStateExample
import com.example.jetpackcompose.ui.screenExamples.retrofit.main.QuoteScreen
import com.example.jetpackcompose.ui.screenExamples.room.NoteScreen
import com.example.jetpackcompose.ui.screenExamples.settings.SettingsScreen
import com.example.jetpackcompose.ui.screenExamples.tabrowscreen.TabRowScreen
import kotlinx.coroutines.launch

@Composable
fun HorizontalPager() {

    val pagerState = rememberPagerState(pageCount = { 15 })
    val coroutineScope = rememberCoroutineScope()

    var showDialog by remember { mutableStateOf(false) }
    var pageNumber by remember { mutableStateOf("") }

    Scaffold(
        topBar = { MainAppBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = {

                showDialog = true
            }) {
                Text("Go to any page")
            }
        }
    ) { paddingValues ->


        HorizontalPager(
            // count = 14, // number of screens
            state = pagerState,
            modifier = Modifier.padding(paddingValues)
        ) { page ->
            when (page) {
                0 -> BoxJC()
                1 -> ButtonTextJC()
                2 -> ColumnJC()
                3 -> RowJC()
                4 -> LazyColumnJC()
                5 -> LazyRowJC()
                6 -> LazyVerticalGridJC()
                7 -> IncrementNumber()
                8 -> ViewMutableStateExample()
                9 -> NavigationCat()
                10 -> NavDrawerJC()
                11 -> NoteScreen()
                12 -> SettingsScreen()
                13 -> TabRowScreen()
                14 -> QuoteScreen()
            }
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Go to Page") },
                text = {
                    Column {
                        Text("Enter the page number:")
                        OutlinedTextField(
                            value = pageNumber,
                            onValueChange = { pageNumber = it },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                    }
                },
                confirmButton = {
                    Button(onClick = {
                        val page = pageNumber.toIntOrNull()
                        if (page != null && page in 0 until pagerState.pageCount) {
                            coroutineScope.launch {
                                pagerState.scrollToPage(page)
                            }
                            showDialog = false
                        }
                    }) {
                        Text("Go")
                    }
                },
                dismissButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HorizontalPager()
}