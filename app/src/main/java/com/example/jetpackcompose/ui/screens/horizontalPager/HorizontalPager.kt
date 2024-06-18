package com.example.jetpackcompose.ui.screens.horizontalPager

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose.examples.BoxJC
import com.example.jetpackcompose.examples.ButtonTextJC
import com.example.jetpackcompose.examples.ColumnJC
import com.example.jetpackcompose.examples.LazyColumnJC
import com.example.jetpackcompose.examples.LazyRowJC
import com.example.jetpackcompose.examples.LazyVerticalGridJC
import com.example.jetpackcompose.examples.RowJC
import com.example.jetpackcompose.examples.counterScreen.IncrementNumber
import com.example.jetpackcompose.examples.mutablestate.ViewMutableStateExample
import com.example.jetpackcompose.ui.screens.cat.MainAppBar
import com.example.jetpackcompose.ui.screens.cat.NavigationCat
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyApp() {

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = { MainAppBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                coroutineScope.launch {

                    pagerState.scrollToPage(6)

                }
            }) {
                Text("Go to page 6")
            }
        }
    ) { paddingValues ->


        HorizontalPager(
            count = 10, // number of screens
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
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}