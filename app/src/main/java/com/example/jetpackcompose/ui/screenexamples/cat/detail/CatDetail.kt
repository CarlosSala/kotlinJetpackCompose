package com.example.jetpackcompose.ui.screenexamples.cat.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.jetpackcompose.model.getMedia
import com.example.jetpackcompose.ui.screenexamples.cat.CatThumb


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
// @Preview(showBackground = true, widthDp = 400, heightDp = 400)
fun CatDetail(mediaId: Int, onBack: () -> Boolean) {

    val mediaItem = remember {
        getMedia().first { it.id == mediaId }
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = mediaItem.title) }) }
    ) { padding ->

        CatThumb(mediaItem = mediaItem, Modifier.padding(padding))
    }
    /*
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Detail Screen $mediaId",
            style = MaterialTheme.typography.headlineMedium
        )
    }
*/
}