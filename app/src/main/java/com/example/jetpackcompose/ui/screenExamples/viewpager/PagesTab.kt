package com.example.jetpackcompose.ui.screenExamples.viewpager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagesTab(viewModel: MenuViewModel) {

    val pagerState = rememberPagerState(pageCount = { 3 })

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TabRow(
            // selectedTabIndex = viewModel.currentPage
            selectedTabIndex = pagerState.currentPage
        ) {
            Tab(
                selected = pagerState.currentPage == 0,
                // selected = viewModel.currentPage == index,
                onClick = { viewModel.mySetCurrentPage(0) },
                text = { Text("Page 1") }
            )
            Tab(
                selected = pagerState.currentPage == 1,
                // selected = viewModel.currentPage == index,
                onClick = { viewModel.mySetCurrentPage(1) },
                text = { Text("Page 2") }
            )
            Tab(
                selected = pagerState.currentPage == 2,
                // selected = viewModel.currentPage == index,
                onClick = { viewModel.mySetCurrentPage(2) },
                text = { Text("Page 3") }
            )

            // Llamar al Composable de pantalla basado en la página actual
            when (viewModel.currentPage) {
                0 -> Screen1()
                1 -> Screen2()
                2 -> Screen3()
            }
            /*Tab(
                text = { Text("Screen 1") },
                selected = pagerState.currentPage == 0,
                onClick = { }// pagerState.animateScrollToPage(0) }
            )
            Tab(
                text = { Text("Screen 2") },
                selected = pagerState.currentPage == 1,
                onClick = { }// pagerState.animateScrollToPage(1) }
            )
            Tab(
                text = { Text("Screen 3") },
                selected = pagerState.currentPage == 2,
                onClick = { }// pagerState.animateScrollToPage(2) }
            )*/
        }


    }
}
