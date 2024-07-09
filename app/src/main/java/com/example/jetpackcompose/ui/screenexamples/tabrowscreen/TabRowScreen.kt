package com.example.jetpackcompose.ui.screenexamples.tabrowscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

@Composable
fun TabRowScreen() {

    val viewModel: TabRowViewModel = viewModel()
    val coroutineScope = rememberCoroutineScope()
    val screenTitles = listOf("News", "Quotes", "About System")
    val pagerState = rememberPagerState(
        initialPage = viewModel.currentPage,
        pageCount = { screenTitles.size }
    )

    Column(
        Modifier.fillMaxSize()
    ) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            containerColor = Color.LightGray,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ) {
            screenTitles.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        viewModel.mySetCurrentPage(index)
                        // Animate swipe screen
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = { Text(title) }
                )
            }
        }

        // pages content
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            when (page) {
                0 -> Screen1()
                1 -> Screen2()
                2 -> Screen3()
            }
        }

        // Update ViewModel when swipe
        LaunchedEffect(pagerState.currentPage) {
            viewModel.mySetCurrentPage(pagerState.currentPage)
        }
    }
}