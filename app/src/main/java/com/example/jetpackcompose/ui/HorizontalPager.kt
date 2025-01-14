package com.example.jetpackcompose.ui


import com.example.jetpackcompose.ui.screenexamples.service2.DownloadScreen
import LazyColumnDragAndDrop
import NotificationExample
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
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
import androidx.compose.material3.lightColorScheme
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
import com.example.jetpackcompose.ui.common.MainTopAppBar
import com.example.jetpackcompose.ui.common.Screens
import com.example.jetpackcompose.ui.screenexamples.BoxJC
import com.example.jetpackcompose.ui.screenexamples.ButtonTextJC
import com.example.jetpackcompose.ui.screenexamples.ColumnJC
import com.example.jetpackcompose.ui.screenexamples.ConstraintJC
import com.example.jetpackcompose.ui.screenexamples.ConstraintJC2
import com.example.jetpackcompose.ui.screenexamples.LazyColumnJC
import com.example.jetpackcompose.ui.screenexamples.LazyColumnJC2
import com.example.jetpackcompose.ui.screenexamples.LazyHorizontalGridJC
import com.example.jetpackcompose.ui.screenexamples.LazyRowJC
import com.example.jetpackcompose.ui.screenexamples.LazyVerticalGridDragAndDrop
import com.example.jetpackcompose.ui.screenexamples.LazyVerticalGridJC
import com.example.jetpackcompose.ui.screenexamples.NavDrawerJC
import com.example.jetpackcompose.ui.screenexamples.PullRefreshJC
import com.example.jetpackcompose.ui.screenexamples.RowJC
import com.example.jetpackcompose.ui.screenexamples.SnackBarJC
import com.example.jetpackcompose.ui.screenexamples.SouthAmericanQualifiersScreen
import com.example.jetpackcompose.ui.screenexamples.catnavigation.CatNavigation
import com.example.jetpackcompose.ui.screenexamples.counterscreen.CounterScreen
import com.example.jetpackcompose.ui.screenexamples.firebasestorage.FirebaseStorageScreen
import com.example.jetpackcompose.ui.screenexamples.firestorescreen.CrudFireStoreScreen
import com.example.jetpackcompose.ui.screenexamples.login.LoginJetpackComposeScreen
import com.example.jetpackcompose.ui.screenexamples.mutablestate.MutableStateExamplePreview
import com.example.jetpackcompose.ui.screenexamples.paging.presentation.PagingScreen
import com.example.jetpackcompose.ui.screenexamples.retrofit.main.MovieScreen
import com.example.jetpackcompose.ui.screenexamples.roomnote.NoteScreen
import com.example.jetpackcompose.ui.screenexamples.roomnote2.AppNav
import com.example.jetpackcompose.ui.screenexamples.service.MyServiceScreen
import com.example.jetpackcompose.ui.screenexamples.styles.TestThemes
import com.example.jetpackcompose.ui.screenexamples.styles2.MyTheme
import com.example.jetpackcompose.ui.screenexamples.styles2.StylesScreen
import com.example.jetpackcompose.ui.screenexamples.tabrowscreen.TabRowScreen
import com.example.jetpackcompose.ui.screenexamples.welcomescreen.WelcomeScreen
import com.example.jetpackcompose.ui.screenexamples.worker.MyPeriodicWorkerUI
import com.example.jetpackcompose.ui.screenexamples.worker2.ImageUploadWorkerUI
import com.example.jetpackcompose.ui.screenexamples.worker3.OneTimeWorkRequestUI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HorizontalPager() {

    val pagerState = rememberPagerState(pageCount = { Screens.entries.size })
    val coroutineScope = rememberCoroutineScope()
    var showDialog by remember { mutableStateOf(false) }
    // var pageNumber by remember { mutableStateOf("") }
    var selectedTheme by remember { mutableStateOf(lightColorScheme()) }
    var title by remember { mutableStateOf("") }
    var myWindowInsets by remember { mutableStateOf(WindowInsets(0, 0, 0, 0)) }

    MyTheme(selectedTheme) {

        Scaffold(
            modifier = Modifier.windowInsetsPadding(insets = myWindowInsets),
            //containerColor = Color.Cyan,
            topBar = {
                if (pagerState.currentPage != 34 && pagerState.currentPage != 10) {
                    MainTopAppBar(
                        onTitleChange = title,
                        selectedTheme = { theme ->
                            selectedTheme = theme
                        },
                        onBack = {
                            val currentPage = pagerState.currentPage
                            if (currentPage > 0) {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(currentPage - 1)
                                }
                            }
                        }
                    )
                }
            },
            floatingActionButton = {
                if (pagerState.currentPage != 34 && pagerState.currentPage != 23) {
                    FloatingActionButton(
                        onClick = {
                            showDialog = true
                        }
                    ) {
                        Text("to page")
                    }
                }
            }
        ) { paddingValues ->

            HorizontalPager(
                // count = 14, // number of screens
                state = pagerState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                // use unique id
                key = { page -> Screens.entries[page].displayName },
                // How many pages pre load
                // beyondViewportPageCount = 0
            ) { page ->

                // pagerState always has value of the actual page
                title = Screens.entries[pagerState.currentPage].displayName

                when (Screens.entries[page]) {
                    Screens.BoxJC -> BoxJC { }
                    Screens.ConstraintJC -> ConstraintJC()
                    Screens.ConstraintJC2 -> ConstraintJC2()
                    Screens.ButtonTextJC -> ButtonTextJC()
                    Screens.ColumnJC -> ColumnJC()
                    Screens.RowJC -> RowJC()
                    Screens.TestThemes -> TestThemes()
                    Screens.SnackBarJC -> SnackBarJC()
                    Screens.PullRefreshJC -> PullRefreshJC()
                    Screens.CustomNotifications -> NotificationExample()
                    Screens.VerticalPager -> VerticalPagerExample() { myWindowInsets = it }
                    Screens.LazyColumnJC -> LazyColumnJC()
                    Screens.LazyColumnJC2 -> LazyColumnJC2()
                    Screens.LazyRowJC -> LazyRowJC()
                    Screens.LazyVerticalGridJC -> LazyVerticalGridJC()
                    Screens.LazyHorizontalGridJC -> LazyHorizontalGridJC()
                    Screens.CounterScreen -> CounterScreen()
                    Screens.ViewMutableStateExample -> MutableStateExamplePreview()
                    Screens.CatNavigation -> CatNavigation()
                    Screens.NavDrawerJC -> NavDrawerJC()
                    Screens.NoteScreen -> NoteScreen()
                    Screens.TaskScreen -> AppNav()
                    Screens.WelcomeScreen -> WelcomeScreen()
                    Screens.TabRowScreen -> TabRowScreen()
                    Screens.MovieScreen -> MovieScreen()
                    Screens.CrudFireStoreScreen -> CrudFireStoreScreen()
                    Screens.FirebaseStorageScreen -> FirebaseStorageScreen()
                    Screens.MyServiceScreen -> MyServiceScreen()
                    Screens.MyServiceScreen2 -> DownloadScreen()
                    Screens.MyPeriodicWorkerUI -> MyPeriodicWorkerUI()
                    Screens.ImageUploadWorkerUI -> ImageUploadWorkerUI()
                    Screens.OneTimeWorkRequest -> OneTimeWorkRequestUI()
                    Screens.StylesScreen -> StylesScreen()
                    Screens.LoginJetpackComposeScreen -> LoginJetpackComposeScreen()
                    Screens.LazyColumnDragAndDrop -> LazyColumnDragAndDrop()
                    Screens.PagingScreen -> PagingScreen()
                    Screens.LazyVerticalGridDragAndDrop -> LazyVerticalGridDragAndDrop()
                    Screens.SouthAmericanQualifiersScreen -> SouthAmericanQualifiersScreen()
                }
            }

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
        Box(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "${screen.ordinal + 1}. ${screen.displayName}"
            )
        }
    }
}