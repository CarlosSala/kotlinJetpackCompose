package com.example.jetpackcompose.ui.screens.ma9

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.jetpackcompose.R
import com.example.jetpackcompose.model.MediaItem
import com.example.jetpackcompose.model.getMedia


// @Preview
@Composable
fun MediaList4(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_xsmall)),
        // columns = GridCells.Fixed(2)
        columns = GridCells.Adaptive(dimensionResource(R.dimen.cell_min_width)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_xsmall)),
        modifier = modifier

    ) {
        items(getMedia()) { item ->

            MediaListItem4(item)
        }
    }
}


// @Preview(showBackground = true)
@Composable
fun MediaListItem4(item: MediaItem) {

    Column(
        modifier = Modifier.width(dimensionResource(R.dimen.column_width))
    ) {
        Box(
            modifier = Modifier
                //.fillMaxWidth()
                .height(dimensionResource(R.dimen.box_height))
        ) {

            AsyncImage(
                // "https://loremflickr.com/400/400/cat?lock=1"
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.thumb)
                    //.transformations(CircleCropTransformation())
                    .crossfade(2000)
                    .build(),
                contentDescription = null,
                // modifier = Modifier.clip(RoundedCornerShape(4.dp))
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            if (item.type == MediaItem.Type.VIDEO) {
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
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {

            Text(
                text = item.title,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}