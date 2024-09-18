package com.example.jetpackcompose.ui.screenexamples.catnavigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.model.MediaItem
import com.example.jetpackcompose.model.getMedia


@Composable
fun CatMediaList(
    modifier: Modifier = Modifier,
    onCatClick: (MediaItem) -> Unit
) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_xsmall)),
        columns = GridCells.Adaptive(dimensionResource(R.dimen.cell_min_width)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_xsmall)),
        modifier = modifier
    ) {
        items(getMedia()) { item ->

            MediaListItem4(
                mediaItem = item,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_xsmall))
            ) { myItem ->
                onCatClick(myItem)
            }
        }
    }
}


@Composable
fun MediaListItem4(
    mediaItem: MediaItem,
    modifier: Modifier = Modifier,
    onCatClick: (MediaItem) -> Unit
) {
    Card(
        modifier = modifier.clickable {
            onCatClick(mediaItem)
        },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(2.dp, Color.LightGray),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column {
            CatThumb(mediaItem)
            Title(mediaItem)
        }
    }
}

@Composable
private fun Title(mediaItem: MediaItem) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_medium))
    ) {
        Text(
            text = mediaItem.title,
            style = MaterialTheme.typography.titleSmall
        )
    }
}