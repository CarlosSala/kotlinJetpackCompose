package com.example.jetpackcompose.ui.screenexamples.catnavigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose.model.MediaItem
import com.example.jetpackcompose.ui.common.MyApp

@Preview(showSystemUi = true)
@Composable
fun CatScreenPreview() {
    CatScreen { }
}

@Composable
fun CatScreen(
    onCatClick: (MediaItem) -> Unit
) {
    MyApp {
        Scaffold(contentWindowInsets = WindowInsets(top = 0)) { paddingValues ->
            CatMediaList(
                modifier = Modifier.padding(paddingValues)
            ) { myItem ->
                onCatClick(myItem)
            }
        }
    }
}