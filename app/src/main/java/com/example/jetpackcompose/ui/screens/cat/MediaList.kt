package com.example.jetpackcompose.ui.screens.cat

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
import androidx.navigation.NavHostController
import com.example.jetpackcompose.R
import com.example.jetpackcompose.model.MediaItem
import com.example.jetpackcompose.model.getMedia
import com.example.jetpackcompose.ui.common.Thumb


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

            MediaListItem4(
                navController,
                item,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_xsmall))
            )
        }
    }
}


// @Preview(showBackground = true)
@Composable
fun MediaListItem4(
    navController: NavHostController,
    mediaItem: MediaItem,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .clickable { navController.navigate("detail/${mediaItem.id}") },
        // .width(dimensionResource(R.dimen.column_width)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
        // shape = RoundedCornerShape(4.dp)
        border = BorderStroke(1.dp, Color.LightGray),
        // colors = CardDefaults.cardColors(Color.DarkGray)
    ) {
        Column {
            Thumb(mediaItem)
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
            //.background(Color.White)
            .padding(dimensionResource(R.dimen.padding_medium))
    ) {

        Text(
            text = mediaItem.title,
            style = MaterialTheme.typography.titleSmall
        )
    }
}