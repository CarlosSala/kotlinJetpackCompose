package com.example.jetpackcompose.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.jetpackcompose.ui.common.Screens
import com.example.jetpackcompose.ui.screenexamples.BoxJC
import com.example.jetpackcompose.ui.screenexamples.ButtonTextJC
import com.example.jetpackcompose.ui.screenexamples.ColumnJC
import com.example.jetpackcompose.ui.screenexamples.LazyColumnJC
import com.example.jetpackcompose.ui.screenexamples.LazyHorizontalGridJC
import com.example.jetpackcompose.ui.screenexamples.LazyRowJC
import com.example.jetpackcompose.ui.screenexamples.LazyVerticalGridJC
import com.example.jetpackcompose.ui.screenexamples.NavDrawerJC
import com.example.jetpackcompose.ui.screenexamples.RowJC
import com.example.jetpackcompose.ui.common.MainTopAppBar
import com.example.jetpackcompose.ui.screenexamples.cat.CatNavigation
import com.example.jetpackcompose.ui.screenexamples.counterscreen.IncrementNumber
import com.example.jetpackcompose.ui.screenexamples.firebasestorage.FirebaseStorageScreen
import com.example.jetpackcompose.ui.screenexamples.firestorescreen.CrudFirestoreScreen
import com.example.jetpackcompose.ui.screenexamples.mutablestate.ViewMutableStateExample
import com.example.jetpackcompose.ui.screenexamples.retrofit.main.QuoteScreen
import com.example.jetpackcompose.ui.screenexamples.room.NoteScreen
import com.example.jetpackcompose.ui.screenexamples.service.MyServiceScreen
import com.example.jetpackcompose.ui.screenexamples.settings.SettingsScreen
import com.example.jetpackcompose.ui.screenexamples.tabrowscreen.TabRowScreen
import com.example.jetpackcompose.ui.screenexamples.worker2.ImageUploadWorkerUI
import com.example.jetpackcompose.ui.screenexamples.worker.MyPeriodicWorkerUI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HorizontalPager() {

    val pagerState = rememberPagerState(pageCount = { Screens.entries.size })
    val coroutineScope = rememberCoroutineScope()

    var showDialog by remember { mutableStateOf(false) }
    var pageNumber by remember { mutableStateOf("") }

    Scaffold(
        topBar = { MainTopAppBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = {

                showDialog = true
            }) {
                Text("to page")
            }
        }
    ) { paddingValues ->


        HorizontalPager(
            // count = 14, // number of screens
            state = pagerState,
            modifier = Modifier.padding(paddingValues)
        ) { page ->
            when (Screens.entries[page]) {

                Screens.BoxJC -> BoxJC()
                Screens.ButtonTextJC -> ButtonTextJC()
                Screens.ColumnJC -> ColumnJC()
                Screens.RowJC -> RowJC()
                Screens.LazyColumnJC -> LazyColumnJC()
                Screens.LazyRowJC -> LazyRowJC()
                Screens.LazyVerticalGridJC -> LazyVerticalGridJC()
                Screens.LazyHorizontalGridJC -> LazyHorizontalGridJC()
                Screens.IncrementNumber -> IncrementNumber()
                Screens.ViewMutableStateExample -> ViewMutableStateExample()
                Screens.CatNavigation -> CatNavigation()
                Screens.NavDrawerJC -> NavDrawerJC()
                Screens.NoteScreen -> NoteScreen()
                Screens.SettingsScreen -> SettingsScreen()
                Screens.TabRowScreen -> TabRowScreen()
                Screens.QuoteScreen -> QuoteScreen()
                Screens.CrudFireStoreScreen -> CrudFirestoreScreen()
                Screens.FirebaseStorageScreen -> FirebaseStorageScreen()
                Screens.MyServiceScreen -> MyServiceScreen()
                Screens.MyPeriodicWorkerUI -> MyPeriodicWorkerUI()
                Screens.ImageUploadWorkerUI -> ImageUploadWorkerUI()
            }
        }

        if (showDialog) {

            Dialog(
                onDismissRequest = { showDialog = false }
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
                        Box(modifier = Modifier.fillMaxHeight()) {
                            LazyColumn(
                                modifier = Modifier.padding(16.dp)
                            )
                            {
                                items(Screens.entries) { screen ->
                                    ItemScreens(screen, pagerState, coroutineScope) {
                                        showDialog = it
                                    }
                                }
                            }
                        }
                    }
                }
            }


            /*AlertDialog(
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
            )*/
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HorizontalPager()
}


@Composable
fun ItemScreens(
    screen: Screens,
    pagerState: PagerState,
    coroutineScope: CoroutineScope,
    onDismissDialog: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = {
            coroutineScope.launch {
                pagerState.scrollToPage(screen.ordinal)
                onDismissDialog(false)
            }
        },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(modifier = Modifier.padding(16.dp)) {
            Text(text = "${screen.ordinal + 1}. ${screen.displayName}")
        }
    }
}