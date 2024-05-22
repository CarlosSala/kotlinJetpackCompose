package com.example.jetpackcompose.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.jetpackcompose.R
import com.example.jetpackcompose.model.MediaItem


@Composable
fun Thumb(mediaItem: MediaItem, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            //.fillMaxWidth()
            .height(dimensionResource(R.dimen.box_height))
    ) {

        AsyncImage(
            // "https://loremflickr.com/400/400/cat?lock=1"
            model = ImageRequest.Builder(LocalContext.current)
                .data(mediaItem.thumb)
                //.transformations(CircleCropTransformation())
                .crossfade(2000)
                .build(),
            contentDescription = null,
            // modifier = Modifier.clip(RoundedCornerShape(4.dp))
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        if (mediaItem.type == MediaItem.Type.VIDEO) {
            Icon(
                imageVector = Icons.Default.PlayCircleOutline,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.play_icon_size))
                    .align(Alignment.Center)
            )
        }
    }
}