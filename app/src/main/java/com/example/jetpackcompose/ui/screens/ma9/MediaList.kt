package com.example.jetpackcompose.ui.screens.ma9

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import com.example.jetpackcompose.ui.screens.common.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import com.example.jetpackcompose.R
import com.example.jetpackcompose.model.MediaItem
import com.example.jetpackcompose.model.getMedia


// @Preview
@Composable
fun MediaList4(navController: NavHostController, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_xsmall)),
        // columns = GridCells.Fixed(2)
        columns = GridCells.Adaptive(dimensionResource(R.dimen.cell_min_width)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_xsmall)),
        modifier = modifier

    ) {
        items(getMedia()) { item ->

            MediaListItem4(navController, item)
        }
    }
}


// @Preview(showBackground = true)
@Composable
fun MediaListItem4(
    navController: NavHostController,
    mediaItem: MediaItem
) {

    Column(
        modifier = Modifier
            .width(dimensionResource(R.dimen.column_width))
            .clickable { navController.navigate("detail/${mediaItem.id}") }
    ) {
        Thumb(mediaItem)
        Title(mediaItem)
    }
}

@Composable
private fun Title(mediaItem: MediaItem) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(dimensionResource(R.dimen.padding_medium))
    ) {

        Text(
            text = mediaItem.title,
            style = MaterialTheme.typography.titleSmall
        )
    }
}
