package com.example.jetpackcompose.ui.screenExamples.viewpager

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MenuScreen() {
    val viewModel: MenuViewModel = viewModel()
    val screenTitles = listOf("Pantalla 1", "Pantalla 2", "Pantalla 3")
    val pagerState = rememberPagerState(initialPage = viewModel.currentPage)
    val coroutineScope = rememberCoroutineScope()

    Column(Modifier.fillMaxSize()) {

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
                        // Animar el desplazamiento del pager
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = { Text(title) }
                )
            }
        }

        // HorizontalPager para el contenido de cada pantalla
        HorizontalPager(
            count = screenTitles.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            when (page) {
                0 -> Screen1()
                1 -> Screen2()
                2 -> Screen3()
            }
        }

        // Actualiza el ViewModel cada vez que se desliza a una nueva página
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
