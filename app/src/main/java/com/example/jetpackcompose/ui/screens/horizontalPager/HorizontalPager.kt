package com.example.jetpackcompose.ui.screens.horizontalPager

import androidx.compose.runtime.Composable
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
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyApp() {
    val pagerState = rememberPagerState()

    HorizontalPager(
        count = 9, // number of screens
        state = pagerState
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
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}