package com.example.jetpackcompose.ui.screenexamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.jetpackcompose.model.MediaItem
import com.example.jetpackcompose.model.MediaItem.Type
import com.example.jetpackcompose.model.getMedia
import com.example.jetpackcompose.ui.theme.CustomComposeTheme

class LazyColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomComposeTheme {

            }
        }
    }
}


@Preview(
    showBackground = true,
    widthDp = 350,
    heightDp = 800
)
@Composable
fun LazyColumnJC() {

    LazyColumn(
        contentPadding = PaddingValues(2.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(getMedia()) { item ->
            MediaListItem(item)
        }
    }
}

@Composable
fun MediaListItem(item: MediaItem, modifier: Modifier = Modifier) {

    Column {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(color = Color.DarkGray)
        ) {
            AsyncImage(
                // model = "https://loremflickr.com/400/400/cat?lock=1",
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(item.thumb)
                    //.transformations(CircleCropTransformation())
                    .crossfade(1000)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            if (item.type == Type.VIDEO) {
                Icon(
                    imageVector = Icons.Default.PlayCircleOutline,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(90.dp)
                        .align(Alignment.Center)
                )
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(10.dp)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}