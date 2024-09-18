package com.example.jetpackcompose.ui.screenexamples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.CustomComposeTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview(showSystemUi = true)
@Composable
fun PullRefreshJC() {

    CustomComposeTheme {
        val items = remember {
            mutableListOf(*(1..20).map { "Item $it" }.toTypedArray())
        }

        var isRefreshing by remember { mutableStateOf(false) }
        val scope = rememberCoroutineScope()

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            PullToRefreshLazyColumn(
                items = items,
                content = { Text(text = it) },
                isRefreshing = isRefreshing,
                onRefresh = {
                    scope.launch {
                        isRefreshing = true
                        delay(1000)
                        val newItem = "Item ${items.size + 1}"
                        items.add(newItem)
                        isRefreshing = false
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun <T> PullToRefreshLazyColumn(
    items: List<T>,
    content: @Composable (T) -> Unit,
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
    lazyListState: LazyListState = rememberLazyListState()
) {
    val pullToRefreshState = rememberPullRefreshState(isRefreshing, onRefresh = onRefresh)

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            state = lazyListState,
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .pullRefresh(pullToRefreshState),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(items) {
                content(it)
            }

        }
        PullRefreshIndicator(
            refreshing = isRefreshing,
            state = pullToRefreshState,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}