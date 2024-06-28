package com.example.jetpackcompose.ui.screenExamples.tabrowscreen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.ExperimentalFoundationApi

import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabRowScreen() {

    val viewModel: TabRowViewModel = viewModel()
    val screenTitles = listOf("News", "Quotes", "About System")
    val pagerState = rememberPagerState(initialPage = viewModel.currentPage, pageCount = { 3 })
    val coroutineScope = rememberCoroutineScope()

    Column(
        Modifier.fillMaxSize()
    ) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            // backgroundColor = MaterialTheme.colorScheme.surface,
            // contentColor = MaterialTheme.colorScheme.onSurface
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


/*    val viewModel: MenuViewModel = viewModel()
    val pagerState = rememberPagerState(0)

    Column(
        Modifier.fillMaxSize()
    ) {
        HorizontalPager(
            count = 3,
            modifier = Modifier.weight(1f),
            state = pagerState
        ) { page ->

            when (page) {
                0 -> Screen1()
                1 -> Screen2()
                2 -> Screen3()
            }

            // viewModel.mySetCurrentPage(page)
        }

       // PagesTab(viewModel = viewModel)
    }
}*/
