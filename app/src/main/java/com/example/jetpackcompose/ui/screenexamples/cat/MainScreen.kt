package com.example.jetpackcompose.ui.screenexamples.cat

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetpackcompose.model.MediaItem
import com.example.jetpackcompose.ui.common.MyApp

@Composable
fun MainScreen(
    myClick: (MediaItem) -> Unit,
) {
    MyApp {
        Scaffold(
            topBar = { MainAppBar() }
        ) { paddingValues ->

            MediaList4(
                modifier = Modifier.padding(paddingValues)
            ) { myItem ->

                myClick(myItem)
            }
        }
    }
}