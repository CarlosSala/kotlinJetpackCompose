package com.example.jetpackcompose.ui.screenexamples.cat

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetpackcompose.model.MediaItem
import com.example.jetpackcompose.ui.common.MyApp


@Composable
fun CatScreen(
    onCatClick: (MediaItem) -> Unit
) {
    MyApp {
        Scaffold { paddingValues ->

            CatMediaList(
                modifier = Modifier.padding(paddingValues)
            ) { myItem ->

                onCatClick(myItem)
            }
        }
    }
}