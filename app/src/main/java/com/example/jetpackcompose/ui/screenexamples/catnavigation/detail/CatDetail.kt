package com.example.jetpackcompose.ui.screenexamples.catnavigation.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.model.getMedia
import com.example.jetpackcompose.ui.screenexamples.catnavigation.CatThumb

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(showBackground = true, widthDp = 400, heightDp = 400)
fun CatDetail(
    mediaId: Int = 1,
    onBack: () -> Unit = {}
) {
    val mediaItem = remember { getMedia().first { it.id == mediaId } }

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = mediaItem.title) }) }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CatThumb(
                mediaItem = mediaItem
            )
            Text(
                text = "Detail Screen ${mediaItem.type}",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Button(
                onClick = {
                    onBack()
                }
            ) {
                Text("go back")
            }
        }
    }
}