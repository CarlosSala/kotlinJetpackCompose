package com.example.jetpackcompose.ui.screens.pager

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyApp() {
    val pagerState = rememberPagerState()

    HorizontalPager(
        count = 3, // Número de pantallas
        state = pagerState
    ) { page ->
        when (page) {
            0 -> Pantalla1()
            1 -> Pantalla2()
            2 -> Pantalla3()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}